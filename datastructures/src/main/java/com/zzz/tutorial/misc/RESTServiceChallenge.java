package com.zzz.tutorial.misc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RESTServiceChallenge {

    public static void main(String[] args) throws IOException {

        String[] res;

        res = getMovieTitles("we");
        if (res != null && res.length > 0)
            Arrays.stream(res).forEach((item) -> System.out.println(item));

    }
    /*
     * Complete the function below.
     */
    private static String QUERY_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
    private static HttpURLConnection connection;
    private static Gson gson = new Gson();

    static String[] getMovieTitles(String substr) {
        if (substr == null || substr.length() == 0)
            return new String[0];

        // Set up the URL for the first page
        try {
            return setupAndQuery(substr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String[0];
    }

    static String[] setupAndQuery(String substr) {
        MovieResponse movieResponse = null;
        BufferedReader reader = null;
        try {
            // Setup the URL object
            URL url = new URL(QUERY_URL + substr);
            // Create the connection
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int response = connection.getResponseCode();

            // Check for Successfull response

            StringBuilder resp = new StringBuilder();

            if (response == 200) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                // Read the input
                movieResponse = readInput(reader);
                if (movieResponse != null) {
                    // If there is more data to be gotten, get all the data
                    if (movieResponse.gettotal_pages() > 0)
                        getAllMovies(movieResponse, QUERY_URL, substr);

                    return filterAndSort(movieResponse);
                }
            } else {
                System.out.println("Error Occured with response: " + response);
            }
        } catch (IOException e) {
            System.out.println("setupAndQuery(): Error occured" + e.getMessage());

        } finally {
            // Close the resources
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String[0]; // Error Case
    }

    private static String[] filterAndSort(MovieResponse movieResponse) {
        // Filter the movies which does not contain the poster
        List<Movies> result = null;
        if (movieResponse.getData() != null && movieResponse.getData().size() > 0) {
            result = movieResponse.getData().stream()
                    .filter(item -> !item.getPoster().trim().equalsIgnoreCase("N/A"))
                    .collect(Collectors.toList());

            //Sort the data via a custom comparator
            if (result != null && result.size() > 0) {
                result.sort((item1, item2) -> {
                    int year = item1.getYear().compareTo(item2.getYear());
                    // If the year is equal we want to sort by Title
                    if (year == 0) {
                        return item1.getTitle().compareTo(item2.getTitle());
                    } else {
                        return year;
                    }
                });
            }
        }
        // Create the result array
        if (result != null && result.size() > 0) {
            String[] output = new String[result.size()];
            for (int i = 0; i < result.size(); i++) {
                output[i] = result.get(i).getTitle();
            }
            return output;
        }
        return new String[0];
    }

    private static void getAllMovies(MovieResponse initialMovie, String uri, String substr) throws IOException {
        // Create the connection
        // Add the page to the URI.
        int response;
        BufferedReader reader = null;
        URL url;
        StringBuilder jsonResponse;
        MovieResponse movieResponse = null;
        String input;
        // Start from Page 2 - as we have already seen page 1
        for (int i = 2; i <= initialMovie.gettotal_pages(); i++) {
            jsonResponse = new StringBuilder();
            try {
                url = new URL(QUERY_URL + substr + "&page=" + i);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                response = connection.getResponseCode();
                if (response == 200) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((input = reader.readLine()) != null)
                        jsonResponse.append(input);
                    movieResponse = gson.fromJson(jsonResponse.toString(), MovieResponse.class);
                    initialMovie.getData().addAll(movieResponse.getData());
                } else {
                    // Possibly an error in connecting
                    break;
                }
            } catch (Exception e) {
                System.out.println("getAllMovies: () Exception Occured:" + e.getMessage());
            } finally {
                if (reader != null)
                    reader.close();
            }

        }
    }

    private static MovieResponse readInput(BufferedReader reader) {
        StringBuilder jsonResponse = new StringBuilder();

        // Get the response into a json string
        reader.lines().forEach((item) -> jsonResponse.append(item));

        MovieResponse movieResponse = gson.fromJson(jsonResponse.toString(), MovieResponse.class);
        if (movieResponse == null) {
            System.out.println("Could not convert from JSON");
            return null;
        }
        return movieResponse;
    }

    private static class MovieResponse {
        private String page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private List<Movies> data;

        public MovieResponse() {

        }

        public Integer gettotal_pages() {
            return total_pages;
        }

        public void settotal_pages(Integer pages) {
            this.total_pages = pages;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public void setPer_page(Integer per_page) {
            this.per_page = per_page;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<Movies> getData() {
            return data;
        }

        public void setData(List<Movies> data) {
            this.data = data;
        }
    }

    private static class Movies {

        @SerializedName("Title")
        private String title;
        @SerializedName("Poster")
        private String poster;
        @SerializedName("Type")
        private String type;
        @SerializedName("Year")
        private Integer year;
        @SerializedName("imdbID")
        private String imdbId;

        public Movies() {

        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public String getImdbId() {
            return imdbId;
        }

        public void setImdbId(String imdbId) {
            this.imdbId = imdbId;
        }
    }
}

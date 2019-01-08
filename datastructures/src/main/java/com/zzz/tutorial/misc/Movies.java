package com.zzz.tutorial.misc;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Movies {
    /*
     * Complete the function below.
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getMovieTitles(_substr);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static String[] getMovieTitles(String substr) {
        if (substr == null || substr.length() == 0)
            return null;

        // Set up the URL for the first page
        try {
            setupAndQuery(substr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    static String[] setupAndQuery(String substr) throws Exception {
        // Setup the URL object
        String uri = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr;
        URL url = new URL(uri);

        // Create the connection
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int response = con.getResponseCode();

        // Check for Successfull response
        BufferedReader reader = null;
        StringBuilder resp = new StringBuilder();
        String input;
        if (response == 200) {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // Read the input
            MovieResponse movieResponse = readInput(reader);
            if (movieResponse == null) {
                System.out.println("Could not convert from JSON");
            }
        } else {
            System.out.println("Error Occured with response: " + response);
        }
        return null;
    }

    private static MovieResponse readInput(BufferedReader reader) {
        Gson gson = new Gson();
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

    private static final class MovieResponse {
        private String page;
        private Integer per_page;
        private Integer total;
        private List<Movie> movies;

        public MovieResponse() {

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

        public List<Movie> getMovies() {
            return movies;
        }

        public void setMovies(List<Movie> movies) {
            this.movies = movies;
        }
    }

    private static final class Movie {
        private String poser;
        private String type;
        private String year;
        private String imdbId;

        public Movie() {

        }

        public String getPoser() {
            return poser;
        }

        public void setPoser(String poser) {
            this.poser = poser;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
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

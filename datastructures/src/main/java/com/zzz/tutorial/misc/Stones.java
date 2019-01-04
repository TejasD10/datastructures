package com.zzz.tutorial.misc;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lastStoneWeight' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lastStoneWeight(List<Integer> a) {
        // Boundary cases
        if (a == null || a.size() == 0)
            return 0;
        if (a.size() == 1) // That is the remaining stone
            return a.get(0);

        // Need to sort the collection O(n log n)
        Collections.sort(a);
        int result = -1;
        for (int i = a.size() - 1; i >= 0; i--) {
            // Compare with the previous element
            // if both are same, decrement i one more time
            if (i >= 1 && a.get(i) == a.get(i - 1))
                i--;
            else {
                if (result == -1 && i >= 1) {
                    result = Math.abs(a.get(i) - a.get(i - 1));
                    i--;
                } else
                    result = Math.abs(result - a.get(i));
            }
        }
        return result;
    }
}

public class Stones {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriterEAM(System.getenv("OUTPUT_PATH")));
//
//        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());

//        int result = Result.lastStoneWeight(Arrays.asList(1, 2, 3, 5, 7, 7));
        int result = Result.lastStoneWeight(Arrays.asList(46188086,
                339992587,
                742976890,
                801915058,
                393898202,
                717833291,
                843435009,
                361066046,
                884145908,
                668431192,
                586679703,
                792103686,
                85425451,
                246993674,
                134274127,
                586374055,
                923288873,
                292845117,
                399188845,
                842456591,
                410257930,
                333998862,
                16561419,
                624279391,
                459765367,
                969764608,
                508221973,
                82956997,
                437034793,
                553121267,
                554066040,
                199416087));
//        int result = Result.lastStoneWeight(Arrays.asList(3, 2, 4, 5));
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

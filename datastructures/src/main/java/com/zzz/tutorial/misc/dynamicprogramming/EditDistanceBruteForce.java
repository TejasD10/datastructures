package com.zzz.tutorial.misc.dynamicprogramming;

public class EditDistanceBruteForce {

    public static void main(String args[]) {
        String s1 = "JOY";
        String s2 = "BALL";

        System.out.println(editDistanceDP(s1, s2));
//        System.out.println("Edit Disntance: " + editDistanceBrute(s1, s2));
//        System.out.println("Edit Disntance: " + editDistanceBrute(null, null));
    }

    private static int editDistanceBrute(String s1, String s2) {
        // Base Cases
        // 1. If both the strings are null, the Edit distance is zero.
        if (s1 == null || s1.trim().length() == 0 && s2 == null || s2.trim().length() == 0)
            return 0;
        // 2. If one of the strings is empty, the edit distance is the length of the other string
        if (s1 == null || s1.trim().length() == 0 && s2 != null)
            return s2.length();
        if (s2 == null || s2.trim().length() == 0 && s1 != null)
            return s1.length();

        // Check if the first characters of both the strings match
        // if so, the cost of replace is going to be zero
        if (s1.charAt(0) == s2.charAt(0))
            return editDistanceBrute(s1.substring(1), s2.substring(1));
        else { // Otherwise, we need to find the minimum cost of being able to perform either of the operations available.
            return 1 + Math.min(Math.min(editDistanceBrute(s1.substring(1), s2.substring(1)), // Replace the string, if they do not match
                    // Inserting a string in S1, that means one character in s2 has already matched by inserting
                    // the char in s1, so now the comparison is between the whole s1 and the remaining of s2
                    editDistanceBrute(s1, s2.substring(1))),
                    // Delete operation performed on S1, so now the whole s2 needs to be compared
                    // but only the remaining characters in s2
                    editDistanceBrute(s1.substring(1), s2));
        }
    }

    private static int editDistanceDP(String s1, String s2) {
        // Base Cases
        // 1. If both the strings are null, the Edit distance is zero.
        if (s1 == null || s1.trim().length() == 0 && s2 == null || s2.trim().length() == 0)
            return 0;
        // 2. If one of the strings is empty, the edit distance is the length of the other string
        if (s1 == null || s1.trim().length() == 0 && s2 != null)
            return s2.length();
        if (s2 == null || s2.trim().length() == 0 && s1 != null)
            return s1.length();

        //Resulting matrix
        int result[][] = new int[s1.length() + 1][s2.length() + 1];
        // Fill the first row and the first column from 0 and increment by 1
        // as the cost of changing the characters with null is always the index
        // of that character
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        // Fill in the first column
        for (int i = 0; i < result[0].length; i++)
            result[0][i] = i;

        // Now that the first row and columns are filled in
        // Time to fill in the rest
        int min = 0;
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                min = Math.min(Math.min(result[i][j - 1], result[i - 1][j - 1]), result[i - 1][j]);
                if (s1.charAt(i - 1) == s2.charAt((j - 1)))
                    result[i][j] = min;
                else
                    result[i][j] = min + 1;
            }
        }
        return result[s1.length()][s2.length()];
    }
}

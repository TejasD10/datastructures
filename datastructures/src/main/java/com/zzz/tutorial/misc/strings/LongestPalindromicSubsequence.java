package com.zzz.tutorial.misc.strings;

public class LongestPalindromicSubsequence {

    public static int longestPalindromicSubsequence(String str) {
        if (str == null || str.trim().length() == 0)
            return 0;
        return lpsHelper(str.toCharArray(), 0, str.length() - 1);
    }

    // Top Down approach using recursion
    // Can be improved using memoization
    private static int lpsHelper(char[] s, int start, int end) {
        // Base Cases
        if (start == end)
            return 1;  // One Character
        if (s[start] == s[end] && (start + 1) == end)
            return 2; // e.g. for BB, the length of lps is 2
        if (s[start] == s[end])
            return 2 + lpsHelper(s, start + 1, end - 1);
        return Math.max(lpsHelper(s, start + 1, end), lpsHelper(s, start, end - 1));
    }

    //Implement the same using a bottom approach, using tabulation.

    public static int longestPalindromicSubsequence_DP(String s) {
        if (s == null || s.trim().length() == 0)
            return 0;
        int[][] lps = new int[s.length()][s.length()];

        /**
         * Max LPS for a string with 1 character is 1, that means, in a 2d array
         * Each Diagonal element must be set to 1
         */
        for (int i = 0; i < s.length(); i++) {
            lps[i][i] = 1;
        }
        // Length of each sub   strings

        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0, end = 0; (start + len - 1) < s.length(); start++) {
                end = start + len - 1;
                if (s.charAt(start) == s.charAt(end) && len == 2) // Two characters only in the string
                    lps[start][end] = 2;
                else if (s.charAt(start) == s.charAt(end)) {
                    lps[start][end] = 2 + lps[start + 1][end - 1];
                } else {
                    lps[start][end] = Math.max(lps[start + 1][end], lps[start][end - 1]);
                }
            }
        }
        return lps[0][s.length() - 1];
    }

    public static void main(String args[]) {
//        System.out.println("NULL : " + LongestPalindromicSubsequence.longestPalindromicSubsequence(null));
//        System.out.println("B : " + LongestPalindromicSubsequence.longestPalindromicSubsequence("B"));
//        System.out.println("BB " + LongestPalindromicSubsequence.longestPalindromicSubsequence("BB"));
//        System.out.println("BACAB: " + LongestPalindromicSubsequence.longestPalindromicSubsequence("BACAB"));
//        System.out.println("ABCD : " + LongestPalindromicSubsequence.longestPalindromicSubsequence("ABCD"));
//        System.out.println("EBACABF : " + LongestPalindromicSubsequence.longestPalindromicSubsequence("EBACABF"));
//        System.out.println("Blank Strings : " + LongestPalindromicSubsequence.longestPalindromicSubsequence("    "));

        System.out.println("BACAB: " + LongestPalindromicSubsequence.longestPalindromicSubsequence_DP("BACAB"));
    }

}

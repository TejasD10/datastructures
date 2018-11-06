package com.zzz.tutorial.misc.strings;

public class LowestNumberRemovingNDigits {
    public static void main(String arg[]) {
        String input = "4325043";
        int n = 3;
        System.out.println(findMinNumber(input, n, new StringBuilder()));
    }

    private static StringBuilder findMinNumber(String input, int n, StringBuilder res) {
        // If n = 0, there is nothing to remove so append the remaining input
        if (n == 0) {
            res.append(input);
            return res;
        }
        // If len of the string is less than N, you need to remove everything
        if (input.length() <= n)
            return res;

        // Pick the minimum from the first N characters
        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (input.charAt(i) < input.charAt(min))
                min = i;
        }
        res.append(input.charAt(min));

        // Recur for remaining
        findMinNumber(input.substring(min + 1), n - min, res);
        return res;
    }
}



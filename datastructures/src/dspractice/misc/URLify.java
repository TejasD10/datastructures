package dspractice.misc;

import java.util.Scanner;

public class URLify {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        urlify(input.toCharArray(), input.length());
    }

    private static void urlify(char[] input, int length) {
        // Count Spaces
        int countSpaces = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ')
                countSpaces++;
        }
        char result[] = new char[length + (countSpaces * 3)];
        // a b c
        for (int i = 0, j = 0; i < result.length; i++) {
            if (input[i] == ' ') {
                result[j] = '%';
                result[++j] = '2';
                result[++j] ='0';
            } else {
                result[++j] = input[i];
            }
        }
    }

}

package com.zzz.tutorial.misc.strings;

public class PrintStringWithSpaces {

    public static void main(String args[]) {
        String input = "ABC";
        printWithSpaces(input);
    }

    public static void printWithSpaces(String input) {
        if (input == null || input.length() <= 1)
            return;
        char[] buf = new char[input.length() * 2];
        buf[0] = input.charAt(0);
        printWithPatternHelper(input, buf, 1, 1, input.length());
    }

    private static void printWithPatternHelper(String input, char[] buf, int read, int write, int length) {
        if (read == length) {
            System.out.println(buf);
            return;
        }
        // Write the character during this call of recursion
        buf[write] = input.charAt(read);
        printWithPatternHelper(input, buf, read + 1, write + 1, length);

        // The next time this comes in, put in a space
        buf[write] = ' ';
        buf[write + 1] = input.charAt(read);
        printWithPatternHelper(input, buf, read + 1, write + 2, length);
    }
}

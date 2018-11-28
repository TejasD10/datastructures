package com.zzz.tutorial.misc.strings;

public class IntToString {
    public static void main(String[] args) {
        System.out.println(intToStr(-998765));
    }

    private static String intToStr(int input) {
        if (input == 0) {
            return new String("0");
        }
        boolean isNeg = false;

        char temp[] = new char[15];
        if (input < 0) {
            input *= -1;
            isNeg = true;
        }
        int i = 0;
        while (input != 0) {
            temp[i++] = (char) (input % 10 + '0');
            input /= 10;
        }
        StringBuilder sb = new StringBuilder();
        if (isNeg)
            sb.append("-");

        // REverse the temp
        while (i > 0)
            sb.append(temp[--i]);

        return sb.toString();
    }
}

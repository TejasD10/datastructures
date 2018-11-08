package com.zzz.tutorial.misc.strings;

public class UncommonChars {
    public static void main(String args[]) {
        String one = "characters";
        String two = "alphabets";

        int[] hist = new int[26];

        // Iterate on one string
        for (int i = 0; i < one.length(); i++)
            //Mark all the characters in the first string as 1
            hist[one.charAt(i) - 'a'] = 1;

        for (int i = 0; i < two.length(); i++) {
            // While traversing through the second string
            // if the char is 1, i.e. if it was found in the first string
            // set it to -1, else set it 2 denoting it was found in the second string
            if (hist[two.charAt(i) - 'a'] == 1 || hist[two.charAt(i) - 'a'] == -1)
                hist[two.charAt(i) - 'a'] = -1;
            else
                hist[two.charAt(i) -'a'] = 2;
        }


        for (int i = 0; i < hist.length; i++) {
            if (hist[i] == 1 || hist[i] == 2)
                System.out.print(((char) (i + 'a')) + " ");
        }
    }
}

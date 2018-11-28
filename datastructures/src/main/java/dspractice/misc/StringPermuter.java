package dspractice.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermuter {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (input == "") {
            System.out.println("Empty String");
            System.exit(-1);
        }
        if (input != null && input.length() <= 1) {
            System.out.println(input);
            System.exit(0);
        }
        List<String> result;
        result = permute(input);
        System.out.println(result);
    }

    private static List<String> permute(String input) {
        List<String> perms = new ArrayList<>();

        if (input == null)
            return perms;
        if (input.length() == 0) {
            perms.add("");
            return perms;
        }
        char first = input.charAt(0);
        String rem = input.substring(1);
        List<String> words = permute(rem);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                perms.add(insertCharAt(first, word, i));
            }
        }
        return perms;
    }

    private static String insertCharAt(char f, String word, int j){
        String first = word.substring(0,j);
        String last = word.substring(j);
        return first + f + last;
    }

}

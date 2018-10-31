package dspractice.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Check if a string is a permutation of a palindrome string
 */
public class PalindromePermutation {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        //System.out.println(isPalindromePermutation(input));
        System.out.print(checkPalindromePermutation(input));

    }

    /**
     * Checks if the string is a possible permutation of a possible palindrome string
     * O(N) with O(N) extra space for storing the Hash Table.
     * <p>
     * As an optimization, one can also use a integer array and set the counts accordingly
     *
     * @param input
     */
    private static boolean isPalindromePermutation(String input) {
        if (input == null || input.length() <= 1)
            return false;

        //Store the frequency of a character
        Map<Character, Integer> hist = new HashMap<>();

        for (Character c : input.toCharArray()) {
            Character ch = Character.toLowerCase(c);
            if (ch != ' ') {
                if (hist.containsKey(ch))
                    hist.put(ch, hist.get(ch) + 1);
                else hist.put(ch, 1);
            }
        }

        // Get the Odd counts in the string
        int oddCount = 0;
        for (Map.Entry<Character, Integer> item : hist.entrySet()) {
            if (item != null) {
                if (item.getValue() % 2 == 1) {
                    oddCount++;
                }
            }
        }
        return oddCount <= 1;
    }

    /**
     * Check if the phrase is a permutation of a palindrome string using a bit vector.
     *
     * @param phrase
     * @return
     */
    public static boolean checkPalindromePermutation(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return ((bitVector - 1) & bitVector) == 0;
    }

    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            bitVector = toggle(bitVector, c);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int c) {
        if (c < 0) return bitVector;

        int mask = 1 << c;
        if ((bitVector & mask) == 0){
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }
}

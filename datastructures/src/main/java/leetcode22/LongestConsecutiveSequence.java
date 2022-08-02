package leetcode22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     */
    public int longestConsecutive(int[] nums) {
        /*
         The algorithm is to use a Set and insert all the elements there and determine
         if the current element is a start of the sequence or not and keep track of the longest
         sequence seen so far.
         */
        Set<Integer> elements = new HashSet<>();
        Arrays.stream(nums).forEach(elements::add);

        int longest = 0; // Track the longest sequence we've seen
        for (int num : nums) {
            if (!elements.contains(num - 1)) {
                // start of a new sequence
                var length = 1;
                while (elements.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

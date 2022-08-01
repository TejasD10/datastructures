package leetcode22;


import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentElements {
    public int[] topKFrequentSorted(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.putIfAbsent(num, 0);
            counts.put(num, counts.get(num) + 1);
        }
        return counts.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .limit(k)
                .toArray();
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        // 1, 1, 2, 2, 3
        // Create the frequency of the counts of each number in nums
        // for e.g. 1=2, 2=2, 3=1
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        /* Similar logic as bucket sort, but here we are, indexing the array with the counts
        of each number
        for e.g.1=2, 2=2, 3=1
        the array would contain
        [0, [3], [1, 2], 0, 0, 0]
         We are creating an array with nums.length + 1 as there will at least be one number in the input array
         and therefore the count will at least be 1.
         */
        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry entry : freq.entrySet()) {
            if (bucket[(int) entry.getValue()] == null)
                bucket[(int) entry.getValue()] = new ArrayList<>();
            bucket[(int) entry.getValue()].add((Integer) entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        // Taking only K elements from the bucket starting from the end
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].size(); j++) {
                res[index++] = bucket[i].get(j);
            }
            if (index == k) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 2, 2, 3}, 2)));
    }
}

package leetcode22;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();

        Map<String, List<String>> anagrams = new HashMap<>();
        int[] count;

        for (String str : strs) {
            count = new int[26];
            for (char ch : str.toCharArray())
                count[ch - 'a']++;
            String strCount = Arrays.toString(count);
            anagrams.putIfAbsent(strCount, new ArrayList<>());
            anagrams.get(strCount).add(str);
        }
        return anagrams.values().stream().toList();
    }

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}

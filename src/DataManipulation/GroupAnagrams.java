package DataManipulation;

import java.util.*;

public class GroupAnagrams {

    /**
     * Đề bài (LeetCode 49 — Group Anagrams):
     * Cho một mảng các chuỗi strs.
     * Hãy nhóm các từ là anagram của nhau vào cùng một nhóm.
     *
     * Một anagram là một từ được tạo ra bằng cách hoán đổi thứ tự chữ cái của một từ khác.
     * (Ví dụ: "eat", "tea", "ate" là các anagram.)
     *
     * | Input                                   | Output                                        |
     * | --------------------------------------- | --------------------------------------------- |
     * | `["eat","tea","tan","ate","nat","bat"]` | `[["bat"],["nat","tan"],["ate","eat","tea"]]` |
     * | `[""]`                                  | `[[""]]`                                      |
     * | `["a"]`                                 | `[["a"]]`                                     |
     */

    /**
     * Group anagrams using Map<Character,Integer> as signature key (TreeMap -> deterministic order).
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Key: Map<Character,Integer> (unmodifiable TreeMap) -> Value: list of strings that share same freq map
        Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // Build frequency map for this string
            // Use TreeMap so entry order is deterministic (by character order), which makes equals/hashCode consistent
            Map<Character, Integer> freq = new TreeMap<>();
            for (char c : s.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            // IMPORTANT: Make an immutable snapshot to use as a key.
            // If we reuse/modifiy 'freq' later, it would break hashing; unmodifiableMap prevents later modification.
            Map<Character, Integer> key = Collections.unmodifiableMap(freq);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    // Demo
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat", "中文", "文中"};
        List<List<String>> res = groupAnagrams(input);

        // Print groups
        for (List<String> group : res) {
            System.out.println(group);
        }
    }
}

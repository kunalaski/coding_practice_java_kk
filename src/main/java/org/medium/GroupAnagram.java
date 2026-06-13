package org.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            strMap.computeIfAbsent(Arrays.toString(charArr), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(strMap.values());
    }

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        assert result.size() == 3 : "Expected 3 groups but got " + result.size();

        List<List<String>> result2 = groupAnagrams(new String[]{""});
        assert result2.size() == 1 : "Expected 1 group but got " + result2.size();

        List<List<String>> result3 = groupAnagrams(new String[]{"a"});
        assert result3.size() == 1 : "Expected 1 group but got " + result3.size();

        System.out.println("All assertions passed!");
    }
}

package org.easy;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr, tarr);
    }

    public static void main(String[] args) {
        assert isAnagram("anagram", "nagaram");
        assert !isAnagram("rat", "car");
        assert !isAnagram("abc", "ab");
        assert isAnagram("a", "a");
        assert isAnagram("", "");
        assert !isAnagram("aa", "ab");
    }
}

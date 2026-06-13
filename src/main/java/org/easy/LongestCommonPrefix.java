package org.easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        for (int i=0; i<first.length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if(strs[j].equalsIgnoreCase("") || strs[j].length()<=i) {
                    return prefix.toString();
                }
                if(first.charAt(i) != strs[j].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(first.charAt(i));
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"longestcommonprefix","longestcommon","longest"}));
    }

}

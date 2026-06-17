package org.medium;

public class ProcessStringWithSpecialOperations {

    public static String processStr(String s) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i<s.length()) {
            if(s.charAt(i) == '#') {
                sb.append(sb);
            } else if (s.charAt(i) == '%') {
                sb.reverse();
            } else if (s.charAt(i) == '*') {
                if(!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length()-1);
                }
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        assert processStr("a#b%*").equalsIgnoreCase("ba");
        assert processStr("z*#").equalsIgnoreCase("");
    }
    
}

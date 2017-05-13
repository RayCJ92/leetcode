// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0)
            return 0;
        StringBuilder sb = new StringBuilder(""+s.charAt(0));
        int max = 1;
        for (int i = 1; i < s.length(); i++){
            int sameIndex = sb.indexOf(""+s.charAt(i));
            if(-1 == sameIndex)
                sb.append(""+s.charAt(i));
            else{
                String temp = sb.substring(sameIndex+1);
                max = Math.max(max, sb.length());
                sb.setLength(0);
                sb.append(temp+s.charAt(i));
            }
        }
        return Math.max(max, sb.length());
    }
}
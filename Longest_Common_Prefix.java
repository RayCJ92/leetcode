// Write a function to find the longest common prefix string amongst an array of strings.

// #1
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        StringBuffer prefix = new StringBuffer();
        for(int i = 0; i < strs[0].length(); i++){
            int count = 0;
            char first = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() > i && strs[j].charAt(i) == first)
                    count++;
                else
                    break;
            }
            if(count == strs.length-1)
                prefix.append(first);
            else
                break;
        }
        return prefix.toString();
    }
}

// #2 substring first string char by char to match comm0n prefix
public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
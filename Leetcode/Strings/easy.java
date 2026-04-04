package DSA.Leetcode.Strings;

import java.util.*;

public class easy {
    // 1047. Remove All Adjacent Duplicates In String
    public static void removeDuplicates(String s){
        StringBuilder sb = new StringBuilder("");
        for(char ch : s.toCharArray()){
            int len = sb.length();

            if(len > 0 && sb.charAt(len-1) == ch){
                sb.deleteCharAt(len-1);
            }else{
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
}

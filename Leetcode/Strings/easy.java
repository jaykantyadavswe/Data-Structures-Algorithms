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

    // 125. Valid Palindrome - O(n)
    public static boolean isPalindrome(String str){
        String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s.length();

        for(int i=0; i<n/2; i++){
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }

        return true;
    }

    // 242. Valid Anagram
    // Brute Force 
    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i=0; i<ch1.length; i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }

        return true;
    }

    // Better Approach
    public static boolean isAnagram2(String s, String t){
        if(s.length() != t.length()) return false;

        int freq[] = new int[26]; // store freq
        for(int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++; //incerese freq
            freq[t.charAt(i) - 'a']--; //decrease freq
        }

        for(int num : freq){
            if(num != 0){
                return false;
            }
        }

        return true;
    }

    // 
    public static void main(String[] args) {
        // removeDuplicates("abbaca");

        /* String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str)); */

        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));
    }
}

package DSA.Leetcode.Strings;

import java.util.*;

public class Medium {
    // 151. Reverse Words in a String
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        s = reverseStr(s);

        for (int i = 0; i < s.length(); i++) {
            String word = "";
            while (i < n && s.charAt(i) != ' ') {
                word += s.charAt(i++);
            }

            word = reverseStr(word);

            if (word.length() > 0) {
                sb.append(" ").append(word);
            }
        }

        return sb.substring(1);
    }

    // Reverse String
    private static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    // Without using reverse
    public static String reverseWords2(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder("");
        int i = s.length() - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            sb.append(s.substring(i + 1, j + 1));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    // 3. Longest Substring Without Repeating Characters
    // Brute force approach - O(n^2)
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (set.contains(ch)) {
                    break;
                }

                set.add(ch);
                maxLen = Math.max(maxLen, j - i + 1);
            }
            System.out.println(set);
        }

        return maxLen;
    }

    // Optimal Approach (Sliding Window )
    public static int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // using HashMap
    public static int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Permutations in String
    public static boolean checkInclusion(String s1, String s2){
        int freq[] = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int windSize = s1.length();

        for(int i=0; i<s2.length(); i++){
            int windIdx = 0, idx = i;

            int windFreq[] = new int[26];
            while (windIdx < windSize && idx < s2.length()) {
                windFreq[s2.charAt(idx) - 'a']++;
                windIdx++; idx++;
            }

            if(isFreqSame(freq, windFreq)){ //found
                return true;
            }
        }

        return false;
    }

    public static boolean checkInclusion2(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) return false;

        int freq[] = new int[26];
        int windFreq[] = new int[26];

        for(int i=0; i<n1; i++){
            freq[s1.charAt(i) - 'a']++;
            windFreq[s2.charAt(i) - 'a']++;
        }

        if(isFreqSame(freq, windFreq)) return true;

        for(int i=n1; i<n2; i++){
            windFreq[s2.charAt(i) - 'a']++;
            windFreq[s2.charAt(i - n1) - 'a']--;

            if(isFreqSame(freq, windFreq)){
                return true;
            }
        }

        return false;
    }

    private static boolean isFreqSame(int freq[], int windFreq[]){
        for(int i=0; i<26; i++){
            if(freq[i] != windFreq[i]){
                return false;
            }
        }

        return true;
    }

    // 1910. Remove All Occurrences of a Substring
    public static String removeOccurences(String s, String part) {
        while (s.contains(part)) {
            int idx = s.indexOf(part);
            s = s.substring(0, idx) + s.substring(idx + part.length());

        }

        return s;
    }

    public static String removeOccurences2(String s, String part){
        Stack<Character> st = new Stack<>();
        int m = s.length();
        int n = part.length();

        for(int i=0; i<m; i++){
            st.push(s.charAt(i));

            if(st.size() >= n && check(st, part, n) == true){
                for(int j=0; j<n; j++){
                    st.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    private static boolean check(Stack<Character> st, String part, int n){
        Stack<Character> temp = new Stack<>();
        temp.addAll(st);

        for(int i=n-1; i>=0; i--){
            if(temp.peek() != part.charAt(i)){
                return false;
            }

            temp.pop();
        }

        return true;
    }

    public static String removeOccurences3(String s, String part){
        StringBuilder sb = new StringBuilder();
        int n = part.length();

        for(char ch : s.toCharArray()){
            sb.append(ch);

            if(sb.length() >= n){
                String last = sb.substring(sb.length() - n);

                if(last.equals(part)){
                    sb.delete(sb.length() - n, sb.length());
                }
            }
        }

        return sb.toString();
    }

    // 443. String Compression
    public static int compressStr(char chars[]){
        int j = 0;
        for(int i=0; i<chars.length; i++){
            Integer count = 1;

            while (i < chars.length-1 && chars[i] == chars[i+1]) {
                count++;
                i++;
            }

            chars[j++] = chars[i];

            if(count > 1){
                String countStr = String.valueOf(count);
                for(char c : countStr.toCharArray()){
                    chars[j++] = c;
                }
            }
        }

        return j;
    }

    // In-place changes
    public static void strCompression2(char chars[]){
        int write = 0;
        int i = 0;

        while (i < chars.length) {
            int count = 0;
            char current = chars[i];

            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            chars[write++] = current;

            if(count > 1){
                String cnt = String.valueOf(count);

                for(char c : cnt.toCharArray()){
                    chars[write++] = c;
                }
            }
        }

        System.out.println(write);
    }

    // 49. Group Anagrams
    

    public static void main(String[] args) {
        /*
         * String s = "the sky is blue";
         * System.out.println(reverseWords(s));
         */

        /* String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); */

        /* char chars[] = {'a','a','b', 'b', 'c', 'c', 'c'};
        System.out.println(compressStr(chars)); */

        String str[] = {"eat","tea","tan","ate","nat","bat"};
    }
}

package DSA.Leetcode.Strings;

import java.util.HashMap;
import java.util.HashSet;

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

    public static void main(String[] args) {
        /*
         * String s = "the sky is blue";
         * System.out.println(reverseWords(s));
         */

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

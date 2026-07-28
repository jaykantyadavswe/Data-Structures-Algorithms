package Leetcode.DailyChallenge.Strings;

public class medium {
    // Approach - I
    public static void smallestPalindrome(String s) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder halfLeft = new StringBuilder();
        String middle = "";
        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                halfLeft.append((char) (i + 'a'));
                freq[i] -= 2;
            }

            if (freq[i] == 1 && middle.isEmpty()) {
                middle = String.valueOf((char) (i + 'a'));
            }
        }

        String right = new StringBuilder(halfLeft).reverse().toString();

        System.out.println(halfLeft + middle + right);
    }

    // Approach - II
    /* 1.Count the frequency of each character.
       2.Put freq[i] / 2 copies of each character into the left half in alphabetical order.
       3.If a character has an odd frequency, it becomes the middle character.
       4.The right half is the reverse of the left half. 
    */
    public static void smallestPalindrome2(String s) {
        int freq[] = new int[26];

        // Store Freq
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            // Add half of the occurrences
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }

            // Save the middle character (if any)
            if (freq[i] % 2 == 1) {
                middle = (char) (i + 'a');
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (middle != 0) {
            System.out.println(left.toString() + middle + right);
        }

        System.out.println(left.toString() + right);
    }

    public static void main(String[] args) {
        String s = "babab";
        smallestPalindrome2(s);
    }
}

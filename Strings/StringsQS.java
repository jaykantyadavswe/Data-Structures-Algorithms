package DSA.Strings;

public class StringsQS {
    // Check if a String is a Palindrome - O(n)
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    // Give a route containing 4 directions (E, W, N, S), find the shortest path to
    // reach destination
    public static float getShortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            int dir = str.charAt(i);
            // North
            if (dir == 'N') {
                y++;
            }

            // South
            else if (dir == 'S') {
                y--;
            }

            // East
            else if (dir == 'E') {
                x++;
            }

            // West
            else {
                x--;
            }
        }

        int X2 = x * x;
        int Y2 = y * y;

        return (float) Math.sqrt(X2 + Y2);
    }

    // SubString
    public static String subString(String str, int si, int ei) {
        String subStr = "";
        for (int i = si; i < ei; i++) {
            subStr += str.charAt(i);
        }

        return subStr;
    }

    // Find Largest String
    public static void largestStr(String fruits[]) {
        String largest = fruits[0];
        for (int i = 0; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }

        System.out.println("Largest String : " + largest);
    }

    // For a given String convert each the first letter of each word to UPPERCASE
    public static String toUpperCase(String str) { // O(n)
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    // String Compression -O(n)
    public static String strCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(str.charAt(i));

            if (count > 1) {
                sb.append(count.toString());
            }
        }

        return sb.toString();
    }

    public static int compress(char[] chars) {
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            chars[j++] = chars[i];

            if (count > 1) {
                // convert number -> String 
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) { // string to char arrays then one by one store in char array modifie like - 10 -> to place fill - '1', '0'
                    chars[j++] = c;
                }
            }
        }

        return j;
    }

    public static void main(String[] args) {
        String str = "madadm";
        // System.out.println(isPalindrome(str));

        /*
         * String path = "WNEENESENNN";
         * System.out.println(getShortestPath(path));
         */

        /*
         * String str2 = "HelloWorld";
         * System.out.println(subString(str2, 1, 5));
         */

        /*
         * String fruits[] = {"apple", "mango", "banana"};
         * largestStr(fruits);
         */

        /*
         * String str3 = "hi, i am jaykant";
         * System.out.println(toUpperCase(str3));
         */

        String s = "aaabbcdd";
        // System.out.println(strCompression(s));
        char ch[] = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(ch));

       /*  String countStr = "1258";
        for(char c : countStr.toCharArray()){
            System.out.println(c);
        } */

    }

    public static void printString(char ch[]){
        for(int i=0; i<ch.length; i++){
            System.out.print(ch[i] + " ");
        }
    }
}

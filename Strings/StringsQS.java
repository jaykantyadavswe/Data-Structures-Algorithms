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
    public static String subString(String str, int si, int ei){
        String subStr = "";
        for(int i=si; i<ei; i++){
            subStr += str.charAt(i);
        }

        return subStr;
    }

    // Find Largest String
    public static void largestStr(String fruits[]){
        String largest = fruits[0];
        for(int i=0; i<fruits.length; i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }

        System.out.println("Largest String : " + largest);
    }

    public static void main(String[] args) {
        String str = "madadm";
        // System.out.println(isPalindrome(str));

        /*
         * String path = "WNEENESENNN";
         * System.out.println(getShortestPath(path));
         */

        /* String str2 = "HelloWorld";
        System.out.println(subString(str2, 1, 5)); */

        String fruits[] = {"apple", "mango", "banana"};
        largestStr(fruits);        
    }
}

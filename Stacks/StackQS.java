package DSA.Stacks;

import java.util.Stack;

public class StackQS {
    // push At Bottom in Stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a String using a stack
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder res = new StringBuilder("");

        while (!s.isEmpty()) {
            char curr = s.pop();
            res.append(curr);
        }

        return res.toString();
    }

    // Reverse a Stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // Stock Span Problem
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    // Next Greater Element - O(n)
    public static void nextGreaterEle(int arr[], int nextGreater[], Stack<Integer> s) {
        // Step1 - While
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // Step2 - if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // Step3 - Push in Stack
            s.push(i);
        }

        // four form of question
        /*
         * next Greater Right
         * next Greater Left
         * next Smaller Right
         * next Smaller Left
         */
    }

    // Valid Parenthess - O(n)
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }

                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Duplicate Parentheses
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Closing
            if (ch == ')') {
                int count = 0;

                while (s.pop() != '(') {
                    count++;
                }

                if (count < 1) {
                    return true; // duplicate
                }
            } else {
                // Opening
                s.push(ch);
            }

        }

        return false;
    }

    // Max Rectangle area in Histogram - O(n)
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // Next Smaller Right - O(n)
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }
        
        // Next Smaller Left - O(n)
        s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // Current Area: Width = j-i-1 = nsr[i]-nsl[i]-1 - O(n)
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("max area in histogram = " + maxArea);
    }

    public static void main(String[] args) {
        /*
         * Stack<Integer> s = new Stack<>();
         * s.push(1);
         * s.push(2);
         * s.push(3);
         */

        // pushAtBottom(s, 4);
        /*
         * reverseStack(s);
         * printStack(s);
         */

        /*
         * String str = "zero";
         * System.out.println(reverse(str));
         */

        /*
         * int stocks[] = {100, 80, 60, 70, 60, 85, 100};
         * int span[] = new int[stocks.length];
         * stockSpan(stocks, span);
         * 
         * for(int i=0; i<span.length; i++){
         * System.out.print(span[i] + " ");
         * }
         */

        /*
         * int arr[] = { 6, 8, 0, 1, 3 };
         * int nextGreater[] = new int[arr.length];
         * Stack<Integer> s = new Stack<>();
         * nextGreaterEle(arr, nextGreater, s);
         * 
         * printArr(nextGreater);
         */

        /*
         * String str = "({[]}{)})";
         * System.out.println(isValid(str));
         */

        // String str = "((a+b))"; //true
        /* String str = "(a-b)"; // false
        System.out.println(isDuplicate(str)); */

        int arr[] = {2, 1, 5, 6, 2, 3};
        maxArea(arr);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package DSA.Leetcode.Math;

public class medium {
    // 50. Pow(x, n)
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (x == 0)
            return 0.0;
        if (x == 1)
            return 1.0;
        if (x == -1 && n % 2 == 0)
            return 1.0;
        if (x == -1 && n % 2 != 0)
            return -1.0;

        long binForm = n;
        // Handle Negative Cases
        if (n < 0) {
            x = 1 / x;
            binForm = -binForm;
        }
        double ans = 1;

        while (binForm > 0) {
            if (binForm % 2 == 1) {
                ans *= x;
            }

            x *= x;
            binForm /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, 10));
    }
}

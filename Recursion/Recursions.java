public class Recursions {
    // print numbers from n to 1 (Decreasing Order)
    public static void printDec(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }

        System.out.print(n + " ");
        printDec(n-1);
    }

    // print numbers from 1 to n (Increasing Order)
    public static void printInc(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");

    }

    // Print factorial of a Number N -> O(n)
    public static int fact(int n){
        if(n == 0){
            return 1;
        }

        int fnm1 = fact(n-1);
        int fn = n * fnm1;
        return fn;
    }

    // Print sum of first n natural number
    public static int printSumOfNuturalNum(int n){
        if(n == 1){
            return 1;
        }

        int Snm1 = printSumOfNuturalNum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }

    // Print x To the power n
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }

        int xnm1 = power(x, n-1);
        int xn = x * xnm1;
        return xn;
    }

    // Optimized Power function
    public static double power2(double x, int n){
        long N = n;
        if(N < 0){
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
    private static double fastPow(double x, long n){
        if(n == 0){
            return 1;
        }

        double halfpower = fastPow(x, n/2);
        double halfpowerSq = halfpower * halfpower;

        // n is odd
        if(n % 2 != 0){
            halfpowerSq = x * halfpowerSq;
        }

        return halfpowerSq;
    }   
    public static void main(String[] args) {
        int n = 5;
        // printDec(n);
        // printInc(n);
        // System.out.println(power2(2, -2));

        // System.out.println(fact(n));
        System.out.println(printSumOfNuturalNum(n));


    }
}
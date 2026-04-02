import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class medium {
    // 73. Set Matrix Zeroes, using -1 temporary marker
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i, m);
                    markCol(matrix, j, n);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void markRow(int[][] matrix, int row, int m) {
        for (int j = 0; j < m; j++) {
            if (matrix[row][j] != 0 && matrix[row][j] != -1) {
                matrix[row][j] = -1;
            }
        }
    }

    private static void markCol(int[][] matrix, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] != 0 && matrix[i][col] != -1) {
                matrix[i][col] = -1;
            }
        }
    }

    // Better Approach
    public static void setZeroes2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal Approach
    public static void setZeroes3(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int col[m] = {0}; -> matrix[0][..]
        // int row[n] = {0}; -> matrix[..][0]
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;
                    // mark the j-th col
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // check for col & row
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 48. Rotate Image
    // brute force
    public static void rotateImage(int matrix[][]) {
        int mat[][] = new int[matrix.length][matrix[0].length];
        int n = mat.length - 1;
        int m = mat[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mat[j][n - i] = matrix[i][j];
            }
        }

        // Copy back to original matrix
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                matrix[i][j] = mat[i][j];
            }
        }

    }

    // Better Appraoch
    public static void rotateImage2(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int mat[][] = new int[n][m];
        // Step1 - transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[j][i] = matrix[i][j];
            }
        }

        // Step2 - Reverse Each Row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;

            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;

                left++;
                right--;
            }
        }

        // Copy back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = mat[i][j];
            }
        }
    }

    // Optimal Approach
    public static void rotateImage3(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        // step1 - transpose (change in place)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step2 - Reverse Each Row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // 56. Merge Intervals
    public static int[][] merge(int[][] intervals) {
        // Step1: sort Intervals
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> ans = new LinkedList<>();

        // Step2: Traverse
        for (int Interval[] : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < Interval[0]) {
                ans.add(Interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], Interval[1]);
            }
        }

        // Step3: Convert to array
        return ans.toArray(new int[ans.size()][2]);
    }

    public static int[][] merge2(int intervals[][]) {
        // Step1: Sort Interval - using comparator
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> ans = new ArrayList<>();

        // Step2: Traverse
        for (int Interval[] : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < Interval[0]) { 
                ans.add(Interval);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], Interval[1]);
            }
        }

        // Step 3: Convert to array
        return ans.toArray(new int[ans.size()][]);
    }

    // 74. Search a 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while (row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // setZeroes(matrix);
        /*
         * setZeroes2(matrix);
         * for (int[] row : matrix) {
         * for (int v : row) {
         * System.out.print(v + " ");
         * }
         * System.out.println();
         * }
         */

        rotateImage3(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
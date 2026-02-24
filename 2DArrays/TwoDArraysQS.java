import java.util.*;;

public class TwoDArraysQS {
    // Print Spiral Matrix
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j < endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

    }

    // Diagonal Sum
    public static void diagonalSum(int matrix[][]) {
        int sum = 0;

        // brute force
        /*
         * for(int i=0; i<matrix.length; i++){
         * for(int j=0; j<matrix[0].length; j++){
         * if(i == j){
         * sum += matrix[i][j];
         * }else if(i+j == matrix.length-1){
         * sum += matrix[i][j];
         * }
         * }
         * }
         */

        // optimal Approach
        for (int i = 0; i < matrix.length; i++) {
            // pd
            sum += matrix[i][i];
            // sd
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }

        }

        System.out.println("Diagonal Sum : " + sum);
    }

    // Search in Sorted Matrix
    public static boolean staireCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("found key at (" + row + "," + col + ")");
                return true;
            }

            if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found!");
        return false;
    }

    // Print the number of 7's that are in the 2d array
    public static void getNumber7s(int arr[][]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 7) {
                    count++;
                }
            }
        }

        System.out.println("7's in arr in present number : " + count);
    }

    // Print out the sum of the numbers in the second row of the "nums" array.
    public static void sumOfSecRow(int nums[][]) {
        int sum = 0;
        // sum of 2nd row elements
        for (int j = 0; j < nums[0].length; j++) {
            sum += nums[1][j];
        }

        System.out.println("sum is : " + sum);
    }

    // Find Transpose of a matrix
    public static void transposeMatrix(int matrix[][]){
        System.out.println("Before");
        printMatrix(matrix);

        int Transpose[][] = new int[3][2];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                Transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println("After");
        printMatrix(Transpose);
    }

    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        // printSpiral(matrix);
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        // diagonalSum(mat);
        // System.out.println(staireCaseSearch(matrix, 33));

        /*
         * int arr[][] = {{4, 7, 8}, {8, 8, 7}};
         * getNumber7s(arr);
         */

        // int arr[][] = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };
        // sumOfSecRow(arr);

        int matrixs[][] = {{11, 12, 13}, {21, 22, 23}};
        transposeMatrix(matrixs);
    }

    public static void printMatrix(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

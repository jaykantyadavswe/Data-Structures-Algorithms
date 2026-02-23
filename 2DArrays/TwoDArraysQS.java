import java.util.*;;

public class TwoDArraysQS {
    // Print Spiral Matrix
    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for(int j=startCol; j<endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            // Right
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }

            // Bottom
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // Left
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){
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
    public static void diagonalSum(int matrix[][]){
        int sum = 0;

        // brute force
        /* for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i == j){
                    sum += matrix[i][j];
                }else if(i+j == matrix.length-1){
                    sum += matrix[i][j];
                }
            }
        } */

        // optimal Approach
        for(int i=0; i<matrix.length; i++){
            // pd
            sum += matrix[i][i];
            // sd
            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];
            }
                
        }

        System.out.println("Diagonal Sum : " + sum);
    }

    // Search in Sorted Matrix
    public static boolean staireCaseSearch(int matrix[][], int key){
        int row = 0, col = matrix[0].length-1;

        while (row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == key){
                System.out.println("found key at (" + row + "," + col + ")");
                return true;
            }

            if(key < matrix[row][col]){
                col--;
            }else {
                row++;
            }
        }
        System.out.println("key not found!");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        // printSpiral(matrix);
        int mat[][] = {{1,2,3},
              {4,5,6},
              {7,8,9}};
        // diagonalSum(mat);
        System.out.println(staireCaseSearch(matrix, 33));
    }
}

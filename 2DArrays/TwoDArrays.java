import java.util.*;

public class TwoDArrays {
    // Search
    public static boolean search(int matrix[][], int key){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == key){
                    System.out.print("found at cell (" + i + ", " + j + ")");
                    return true;
                }
            }
        }

        return false;
    }

    // Search Largest & Smallest element
    public static void largestAndSearch(int matrix[][]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                max = Math.max(max, matrix[i][j]);
                min = Math.min(min, matrix[i][j]);
            }
        }

        System.out.println("Largest Element : " + max);
        System.out.println("Smallest Element : " + min);
    }
    public static void main(String args[]){
        int matrix[][] = new int[3][3];
        // Row                      Col
        int n = matrix.length, m = matrix[0].length;

        Scanner scn = new Scanner(System.in);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                matrix[i][j] = scn.nextInt();
            }
        }

        // Output
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // search(matrix, 5);
        largestAndSearch(matrix);
    }
}

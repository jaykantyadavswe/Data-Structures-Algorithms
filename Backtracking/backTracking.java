package DSA.Backtracking;

public class backTracking {
    public static void changeArr(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        // recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    // Find SubSets
    public static void findSubSets(String str, String ans, int i) {
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // yes Choice
        findSubSets(str, ans + str.charAt(i), i + 1);

        // No Choice
        findSubSets(str, ans, i + 1);
    }

    // Find Permutations
    public static void findPermutations(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion - O(n * n!)
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // abcde = ab + de
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutations(newStr, ans + curr);
        }
    }

    // N-Queens - O(n!)
    private static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diag left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diag right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            // printBoard(board);
            count++;
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // fuction call
                board[row][j] = 'x'; // backtracking step
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("_________ chess board _________");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    // Grid Ways
    public static int gridWays(int i, int j, int n, int m) {
        // Base Case
        if (i == n - 1 && j == m - 1) { // condition for last cell
            return 1;
        } else if (i == n || j == m) { // boundry cross condition
            return 0;
        }

        int ways1 = gridWays(i + 1, j, n, m);
        int ways2 = gridWays(i, j + 1, n, m);
        return ways1 + ways2;
    }

    // Sudoku Solver
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        // base case
        if(row == 9){
            return true;
        }

        // recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1; digit<=9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){ //soln exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    // isSafe Fn
    private static boolean isSafe(int sudoku[][], int row, int col, int digit){
        // column
        for(int i=0; i<=8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        // row
        for(int j=0; j<=8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        // grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        // 3x3 grid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    // print Sudoku
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /*
         * int arr[] = new int[5];
         * changeArr(arr, 0, 1);
         * printArr(arr);
         */

        /*
         * String str = "abc";
         * findSubSets(str, "", 0);
         */

        // findPermutations("abc", "");

        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // nQueens(board, 0);
        // System.out.println("total ways to solve n queens = " + count);

        // System.out.println(gridWays(0, 0, 3, 3));

        int Sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0}, 
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3}
    };

    if(sudokuSolver(Sudoku, 0, 0)){
        System.out.println("solution exists");
        printSudoku(Sudoku);
    }else{
        System.out.println("Solution does not exists");
    }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

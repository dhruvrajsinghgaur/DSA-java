
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
    int n = 10;
    boolean[][] board = new boolean[n][n];
    
    //nqueens(board, 0);
    System.out.println(nqueenswithcount(board, 0));
        
    }
    // this will return the boards
    static void nqueens(boolean[][] board, int r){
        if (r == board.length) {
           display(board);
           System.out.println();
            return;
        }
        
        for (int c = 0; c < board.length; c++) {
            if(issafe(board, r, c)){
                board[r][c] = true;
                nqueens(board, r+1);
                board[r][c] = false;  // backtracking
            }
           
        }
       
    }
    
    // this will return the boards with count(no.of boards or answers)
     static int nqueenswithcount(boolean[][] board, int r){
        if (r == board.length) {
           display(board);
           System.out.println();
            return 1;
        }
        int count = 0;
        for (int c = 0; c < board.length; c++) {
            if(issafe(board, r, c)){
                board[r][c] = true;
              count +=  nqueenswithcount(board, r+1);
                board[r][c] = false;  // backtracking
            }
           
        }
       return count;
    }
     private static boolean issafe(boolean[][] board, int r, int c) {
            // up
            for (int i = 0; i < r; i++) {
                if (board[i][c]== true) return false;
            }
            // right diagonal
            for (int i = 1; i <= Math.min(r, board.length-c-1); i++) {
                if (board[r-i][c+i]== true) return false;
            }
            // left diagonal
            for (int i = 1; i <= Math.min(r, c); i++) {
                if (board[r-i][c-i]== true) return false;
            }
       return true;
    }

    private static void display(boolean[][] board) {
       for(boolean[] row : board){
        for(boolean cell : row){
            if (cell){
                System.out.print("Q ");
            }
            else{
                System.out.print("X ");
            }

        }
        System.out.println();
       }
    }


     public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        nqueens1(board, 0, result);
        return result;
    }


     static void nqueens1(boolean[][] board, int r, List<List<String>> result){
        if (r == board.length) {
            result.add(display1(board));
            return;
           
        }
        
        for (int c = 0; c < board.length; c++) {
            if(issafe(board, r, c)){
                board[r][c] = true;
                nqueenswithcount(board, r+1);
                board[r][c] = false;  // backtracking
            }
           
        }
     
    }
     private static boolean issafe1(boolean[][] board, int r, int c) {
            // up
            for (int i = 0; i < r; i++) {
                if (board[i][c]== true) return false;
            }
            // right diagonal
            for (int i = 1; i <= Math.min(r, board.length-c-1); i++) {
                if (board[r-i][c+i]== true) return false;
            }
            // left diagonal
            for (int i = 1; i <= Math.min(r, c); i++) {
                if (board[r-i][c-i]== true) return false;
            }
       return true;
    }

  private static List<String> display1(boolean[][] board) {
    List<String> result = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
        String row = ""; // empty string for this row
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j]) {
                row += "Q"; // place queen
            } else {
                row += "."; // empty space
            }
        }

        result.add(row); // add the row to the result
    }

    return result;
}

}

public class SudokuSolver {
    public static void main(String[] args) {
        
        int[][] board = {
                         {5, 3, 0, 0, 7, 0, 0, 0, 0},
                         {6, 0, 0, 1, 9, 5, 0, 0, 0},
                         {0, 9, 8, 0, 0, 0, 0, 6, 0},
                         {8, 0, 0, 0, 6, 0, 0, 0, 3},
                         {4, 0, 0, 8, 0, 3, 0, 0, 1},
                         {7, 0, 0, 0, 2, 0, 0, 0, 6},
                         {0, 6, 0, 0, 0, 0, 2, 8, 0},
                         {0, 0, 0, 4, 1, 9, 0, 0, 5},
                         {0, 0, 0, 0, 8, 0, 0, 7, 9}
                        };

   
    if (solve(board)){
        display(board);
    }
    else{
        System.out.println("cannot be solved");
    }

        
    }
    static boolean solve(int[][] board){
        int n = board.length;
        int r = -1;
        int c = -1;

        boolean emptyleft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    r = i;
                    c = j;
                    emptyleft = false;
                    break;
                }
            }
            if(emptyleft == false){
                break;
            }
        }
        // sudoku is solved
        if (emptyleft == true){
            return true;
        }

        for (int num = 1; num <= board.length; num++) {
            if(issafe(board, r, c, num)){
                board[r][c] = num;
                if(solve(board)){
                    // found the answer
                    return true;
                }
                else{
                    // backtrake
                     board[r][c] = 0;
                }
            }
        }
        return false;  // cannot be solved

    }
    private static boolean issafe(int[][] board, int r, int c, int num){

     // check for row         
      for (int i = 0; i < board.length; i++) {
        if(board[r][i] == num){
            return false;
        }
     }
     // check for col
      for (int i = 0; i < board.length; i++) {
        if(board[i][c] == num){
            return false;
        }
     }
    

     int sqrt = (int) Math.sqrt(board.length);
     int start = r - r % 3;
     int end = c - c % 3;

      for (int i = start; i < start + sqrt; i++) {
        for (int j = end; j < end + sqrt; j++) {
            if(board[i][j] == num){
            return false;
        }
        }
        
     }
      
        return true;
    }

     private static void display(int[][] board) {
       for(int[] row : board){
        for(int num : row){
            System.out.print(num + " ");
        }
        System.out.println();
       }
    }

 
}


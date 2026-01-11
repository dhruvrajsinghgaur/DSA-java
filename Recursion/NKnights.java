public class NKnights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        nknights(board, 0, 0, n);
        System.out.println(nknightswithcount(board, 0, 0, n));
    }

    // prints all answers
    static void nknights(boolean[][] board, int r, int c, int knights){

        if (knights == 0){
            display(board);
            System.out.println();
            return;
        }

         if (r >= board.length){
            return;
        }

         if(c==board.length) {
            nknights(board, r+1, 0, knights);
            return;
            }

        if(isSafe(board, r, c)){
            board[r][c] = true;
            nknights(board, r, c+1, knights-1);
            board[r][c] = false;  // backtrake 
        }
        nknights(board, r, c+1, knights);
    }
    // returnes count value or we can say no. of answers
    static int nknightswithcount(boolean[][] board, int r, int c, int knights){

        if (knights == 0){
            return 1;
        }

         if (r >= board.length){
            return 0;
        }

         if(c==board.length) {
           return nknightswithcount(board, r+1, 0, knights);
            }
        
        int count = 0;
        if(isSafe(board, r, c)){
            board[r][c] = true;
            count += nknightswithcount(board, r, c+1, knights-1);
            board[r][c] = false;  // backtrake 
        }
        count += nknightswithcount(board, r, c+1, knights);

        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c){

    // Up
    if (isvalid(board, r - 2, c - 1) && board[r - 2][c - 1]) return false;
    if (isvalid(board, r - 2, c + 1) && board[r - 2][c + 1]) return false;

    // Down
    if (isvalid(board, r + 2, c - 1) && board[r + 2][c - 1]) return false;
    if (isvalid(board, r + 2, c + 1) && board[r + 2][c + 1]) return false;

    // Right
    if (isvalid(board, r - 1, c + 2) && board[r - 1][c + 2]) return false;
    if (isvalid(board, r + 1, c + 2) && board[r + 1][c + 2]) return false;

    // Left
    if (isvalid(board, r - 1, c - 2) && board[r - 1][c - 2]) return false;
    if (isvalid(board, r + 1, c - 2) && board[r + 1][c - 2]) return false;

        return true;
    }
   private static boolean  isvalid(boolean[][] board, int r, int c){
        if (r >= 0 && r < board.length && c >= 0 && c < board.length) {
            return true;
        }
        return false;
    }
    private static void display(boolean[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]){
                    System.out.print("K ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }


   
    
}

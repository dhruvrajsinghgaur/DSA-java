package Graph;

public class RottenOranges {
    // Problem 994 on Leetcode.
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        while(!alreadyRotten(grid)){
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            boolean change = false;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == 0) continue;
                    if (visited[i][j]) continue;

                    if (grid[i][j] == 2){

                        if (j+1 != grid[0].length){
                            if (grid[i][j+1] == 1) {
                                visited[i][j + 1] = true;
                                change = true;
                                grid[i][j + 1] = 2;
                            }
                        }

                        if (i+1 != grid.length){
                            if (grid[i+1][j] == 1){
                                visited[i+1][j] = true;
                                change = true;
                                grid[i+1][j] = 2;
                            }
                        }

                        if (j-1 >= 0){
                            if (grid[i][j-1] == 1){
                                visited[i][j-1] = true;
                                change = true;
                                grid[i][j-1] = 2;
                            }
                        }

                        if (i-1 >= 0){
                            if (grid[i-1][j] == 1){
                                visited[i-1][j] = true;
                                change = true;
                                grid[i-1][j] = 2;
                            }
                        }

                    }
                }
            }

            if (!change) return -1;

            minutes = minutes + 1;
        }
        return minutes;
    }

    private boolean alreadyRotten(int[][] grid){
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++){
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }
}

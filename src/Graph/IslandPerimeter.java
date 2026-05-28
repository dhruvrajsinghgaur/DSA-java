package DSA_Topics.Graph;

public class IslandPerimeter {
    // Problem 463 on LeetCode.
    // Method 1.
int count = 0;
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(0, 0, grid, visited);
        return count;
    }
    private void dfs(int i, int j, int[][] grid, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;

        if (visited[i][j]) return;

        visited[i][j] = true;

        if(grid[i][j] == 1){
            if (i-1 < 0 || grid[i-1][j] == 0) count = count + 1;
            if (i+1 >= grid.length || grid[i+1][j] == 0) count = count + 1;
            if (j-1 < 0 || grid[i][j-1] == 0) count = count + 1;
            if (j+1 >= grid[0].length || grid[i][j+1] == 0) count = count + 1;
        }

        dfs(i - 1, j, grid, visited);
        dfs(i + 1, j, grid, visited);
        dfs(i, j - 1, grid, visited);
        dfs(i, j + 1, grid, visited);
    }

    // Method 2 (simplest and preferred).
    public int islandPerimeter2(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i-1 < 0 || grid[i-1][j] == 0) count = count + 1;
                    if (i+1 >= grid.length || grid[i+1][j] == 0) count = count + 1;
                    if (j-1 < 0 || grid[i][j-1] == 0) count = count + 1;
                    if (j+1 >= grid[0].length || grid[i][j+1] == 0) count = count + 1;
                }
            }
        }
        return count;
    }

    // Method 3.
    int cnt = 0;
    public int islandPerimeter3(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean b = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    return cnt;
                }
            }
        }
        return cnt;
    }
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            cnt++;
            return;
        }

        if (grid[i][j] == 0){
            cnt++;
            return;
        }

        if (visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);

    }
}

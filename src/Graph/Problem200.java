package Graph;

public class Problem200 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (visited[i][j]) return;
        if (grid[i][j] == '0') return;
        visited[i][j] = true;

        dfs(i-1, j, grid, visited);
        dfs(i+1, j, grid, visited);
        dfs(i, j-1, grid, visited);
        dfs(i, j+1, grid, visited);
    }

    // this method give an isolated 1 surrounded by all 0's.(although not used in the questions).
    public boolean validCount(int i, int j, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i == 0 && j == 0 && grid[i][j] == '1' && grid[i+1][j] == '0' && grid[i][j+1] == '0' && grid[i+1][j+1] == '0') return true;
        if (i == 0 && j == m-1 && grid[i][j] == '1' && grid[i][j-1] == '0' && grid[i+1][j-1] == '0' && grid[i+1][j] == '0') return true;
        if (i == n-1 && j == 0 && grid[i][j] == '1' && grid[i-1][j] == '0' && grid[i-1][j+1] == '0' && grid[i][j+1] == '0') return true;
        if (i == n-1 && j == m-1 && grid[i][j] == '1' && grid[i-1][j] == '0' && grid[i][j-1] == '0' && grid[i-1][j-1] == '0')  return true;
        if (i == 0 && j > 0 && j < m-1 && grid[i][j] == '1' && grid[i][j-1] == '0' && grid[i][j+1] == '0' && grid[i+1][j-1] == '0' && grid[i+1][j] == '0'&& grid[i+1][j+1] == '0') return true;
        if (i > 0 && i < n-1 && j == 0 && grid[i][j] == '1' && grid[i-1][j] == '0' && grid[i+1][j] == '0' && grid[i-1][j+1] == '0' && grid[i][j+1] == '0' && grid[i+1][j+1] == '0') return true;
        if (i == n-1 && j > 0 && j < m-1 && grid[i][j] == '1'  && grid[i-1][j-1] == '0' && grid[i-1][j] == '0' && grid[i-1][j+1] == '0' && grid[i][j-1] == '0' && grid[i][j+1] == '0') return true;
        if (i < n-1 && i > 0 && j == m-1 && grid[i][j] == '1' && grid[i-1][j-1] == '0' && grid[i][j-1] == '0' && grid[i+1][j-1] == '0' && grid[i-1][j] == '0' && grid[i+1][j] == '0') return true;
        if (grid[i][j] == '1' && grid[i+1][j] == '0' && grid[i-1][j] == '0' && grid[i][j+1] == '0' && grid[i][j-1] == '0' && grid[i+1][j+1] == '0' && grid[i-1][j+1] == '0'  && grid[i-1][j-1] == '0' && grid[i+1][j-1] == '0') return true;

        return false;
    }
}

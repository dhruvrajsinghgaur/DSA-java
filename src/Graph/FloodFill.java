package Graph;

public class FloodFill {
    // Problem 733 on LeetCode
    // This is Method 1 for floofFill (this one uses visited array).
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        dfs(image, sr, sc, color, visited, originalColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, boolean[][] visited, int originalColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (visited[sr][sc]) return;
        if (image[sr][sc] != originalColor) return;

        visited[sr][sc] = true;
        image[sr][sc] = color;

        dfs(image, sr - 1, sc, color, visited, originalColor);
        dfs(image, sr + 1, sc, color, visited, originalColor);
        dfs(image, sr, sc - 1, color, visited, originalColor);
        dfs(image, sr, sc + 1, color, visited, originalColor);
    }

    // This is Method 2 for floofFill (this one does not use any visited array).
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;
        dfs(image, sr, sc, color, originalColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int color, int originalColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (image[sr][sc] != originalColor) return;

        image[sr][sc] = color;

        dfs(image, sr - 1, sc, color, originalColor);
        dfs(image, sr + 1, sc, color, originalColor);
        dfs(image, sr, sc - 1, color, originalColor);
        dfs(image, sr, sc + 1, color, originalColor);
    }
}

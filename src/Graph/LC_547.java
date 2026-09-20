package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC_547 {

    // Method 0.
    // TC: O(n).
    // SC: O(n).
    public int findCircleNum (int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
               dfs(isConnected, visited, i);
               count++;
            }
        }
        return count;
    }
    private void dfs (int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    // Method 1.
    // TC: O(n^2 + (V + E)). n^2 for creation of adjacency list.
    // SC: O(n^2).
    public int findCircleNum1 (int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs1(adjList, visited,i);
                count++;
            }
        }

        return count;
    }
    private void dfs1 (List<List<Integer>> adjList, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < adjList.get(i).size(); j++) {
            int neighbor = adjList.get(i).get(j);
            if (!visited[neighbor]) {
                dfs1(adjList, visited, neighbor);
            }
        }
    }

}

package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC_684 {

    // N = number of edges.
    // Here α(U) is the inverse Ackermann function, which is effectively a tiny constant for any practical input approx O(1).

    // Method 0. (it uses DisjointSet).
    // TC: O(N α(N)) ≈ O(N).
    // SC: O(N).
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length + 1);
        for (int i = 0; i < edges.length; i++){
            if (ds.find(edges[i][0]) == ds.find(edges[i][1])) {
                return edges[i];
            } else {
                ds.union(edges[i][0], edges[i][1]);
            }
        }
        return new int[]{};
    }

    // Method 1. (it uses DFS).
    // TC: O(N^2).
    // SC: O(N).
    public int[] findRedundantConnection1(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int si = 0; si < edges.length + 1; si++) {
                adjList.add(new ArrayList<>());
            }
            for (int si = 0; si < i; si++) {
                int element1 = edges[si][0];
                int element2 = edges[si][1];
                adjList.get(element1).add(element2);
                adjList.get(element2).add(element1);
            }
            int element1 = edges[i][0];
            int element2 = edges[i][1];
            boolean[] vt = new boolean[edges.length + 1];
            if (dfs(adjList, element1, element2, vt)) {
                return edges[i];
            }
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> adjList, int element1, int element2, boolean[] vt) {
        vt[element1] = true;
        for (int j = 0; j < adjList.get(element1).size(); j++) {
            if (adjList.get(element1).get(j) == element2) return true;
            if (!vt[adjList.get(element1).get(j)]) {
                if (dfs(adjList, adjList.get(element1).get(j), element2, vt)) {
                    return true;
                }
            }
        }
        return false;
    }
}

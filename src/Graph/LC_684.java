package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC_684 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
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
}

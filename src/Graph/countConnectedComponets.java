package Graph;

import java.util.ArrayList;
import java.util.List;

// HackerRank Question.
public class countConnectedComponets {
    public static int countIsolatedCommunicationGroups(List<List<Integer>> links, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < links.size(); i++){
            int currValue0 = links.get(i).get(0);
            int currValue1 = links.get(i).get(1);

            adjList.get(currValue0).add(currValue1);
            adjList.get(currValue1).add(currValue0);
        }
        int count = 0;
        for (int i = 0; i < adjList.size(); i++){
            if (!visited[i]){
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < adjList.get(i).size(); j++){
            dfs(adjList, visited, adjList.get(i).get(j));
        }
    }

    public static int countIsolatedCommunicationGroups1(List<List<Integer>> links, int n) {
        if (links.isEmpty()) return n;
        List<List<Integer>> groups = new ArrayList<>();
        groups.add(links.get(0));
        for (int i = 1; i < links.size(); i++){
            int currValue0 = links.get(i).get(0);
            int currValue1 = links.get(i).get(1);
            int cv0 = -1;
            int cv1 = -1;
            for(int j = 0; j < groups.size(); j++){
                for (int k = 0; k < groups.get(j).size(); k++) {
                    if (groups.get(j).get(k) == currValue0) {
                        cv0 = j;
                    }
                    if (groups.get(j).get(k) == currValue1) {
                        cv1 = j;
                    }
                }
            }

            if (cv0 == -1 && cv1 == -1){
                groups.add(links.get(i));
                continue;
            }
            if (cv0 == -1){
                groups.get(cv1).add(currValue0);
            }
            if (cv1 == -1){
                groups.get(cv0).add(currValue1);
            }

            if (cv0 != -1 && cv1 != -1 && cv0 != cv1) {
                merge(cv0, cv1, groups);
            }
        }
        int count = 0;
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).size(); j++) {
                count++;
            }
        }
        return groups.size() + (n - count);
    }

    private static void merge(int cv0, int cv1, List<List<Integer>> groups){
        List<Integer> c0 = groups.get(cv0);
        List<Integer> c1 = groups.get(cv1);

        for (int i = 0; i < c1.size(); i++){
            c0.add(c1.get(i));
        }

        // groups.remove(cv0);
        // if (cv0 < cv1) groups.remove(cv1 - 1);
        // else groups.remove(cv1);

        if (cv0 < cv1) {
            groups.remove(cv1);
            groups.remove(cv0);
        } else {
            groups.remove(cv0);
            groups.remove(cv1);
        }

        groups.add(c0);

    }

}

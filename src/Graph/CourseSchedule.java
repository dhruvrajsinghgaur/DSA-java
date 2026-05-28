package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class CourseSchedule {
    // problem 207 on LeetCode
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
       for (int i = 0; i < prerequisites.length; i++) {
           int curr = prerequisites[i][1];
           if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
           }
           map.get(curr).add(prerequisites[i][0]);
       }
       ArrayList<Integer> ts = ts(numCourses, prerequisites, map);

       if (ts.size() == numCourses) return true;

       return false;
    }
    private ArrayList<Integer> ts(int numCourses, int[][] prerequisites, HashMap<Integer, ArrayList<Integer>> map) {
        ArrayList<Integer> ts = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i);
        }
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            indegree.put(list.get(i), 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int curr = prerequisites[i][0];
           indegree.put(curr,indegree.get(curr)+1);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            if (indegree.get(curr) == 0) q.offer(curr);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            ts.add(curr);
            if (!map.containsKey(curr)) continue;
            for (int i = 0; i < map.get(curr).size(); i++) {
                int neighbor = map.get(curr).get(i);
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        return ts;
    }

    // problem 210 on LeetCode
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int curr = prerequisites[i][1];
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(prerequisites[i][0]);
        }
        ArrayList<Integer> ts = ts(numCourses, prerequisites, map);

        int[] order = new int[ts.size()];

        for (int i = 0; i < ts.size(); i++) {
            order[i] = ts.get(i);
        }

        if (ts.size() == numCourses) return order;

        return new int[0];
    }
}

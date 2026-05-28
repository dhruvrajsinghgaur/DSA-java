package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Graph {
    private int vertices;
    private List<Node> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
    }

    public void addEdge(Node v1, Node v2) {
        v1.neighbors.add(v2);
        v2.neighbors.add(v1);
        if (!adjList.contains(v1)) adjList.add(v1);
        if (!adjList.contains(v2)) adjList.add(v2);
    }

    class Node {
        int val;
        List<Node> neighbors;

        public Node() {
            this.val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;

        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node curr = q.poll();
            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node neighbor = curr.neighbors.get(i);
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}

class Graph1 {
    private int vertices;
    public List<List<Integer>> adjList;

    public Graph1(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u ,int v){
        if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        else {
            System.out.println("invalid vertex");
        }
    }

    public  List<Integer> getEdges(int v){
        return adjList.get(v);
    }

    public void printGraph(){
        System.out.println("Adjacency list");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " : ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int src){
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
        System.out.print("BFS Traversal : ");
        while(!queue.isEmpty()){
            int curr =  queue.poll();
            System.out.print(curr + " ");
            for(int i = 0; i < adjList.get(curr).size(); i++){
                int neighbour = adjList.get(curr).get(i);
                if (!visited[neighbour]){
                    queue.add(adjList.get(curr).get(i));
                    visited[neighbour] = true;
                }
            }
        }
    }

    public void DFS(int src){
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal : ");
        DFS(src,visited);
    }
    private void DFS(int src, boolean[] visited){
        visited[src] = true;
        System.out.print(src + " ");
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int curr = adjList.get(src).get(i);
            if (!visited[curr]) {
                DFS(curr, visited);
            }
        }
    }

    // this method uses DFS to detect cycle in an undirected graph.
    public boolean detectCycle(int src){
        boolean[] visited = new boolean[vertices];
        return detectCycle(src, visited, -1);
    }
    public boolean detectCycle(int src, boolean[] visited, int parent){
        visited[src] = true;
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int curr = adjList.get(src).get(i);
            if (visited[curr] && curr != parent) return true;
            if (!visited[curr]){
                if(detectCycle(curr, visited, src)) return true;
            }
        }
        return false;
    }

    // this method uses BFS to detect cycle in an undirected graph.
    public boolean detectCycle2(int src){
        boolean[] visited = new boolean[vertices];
        int[] parent  = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        parent[src] = -1;
        queue.add(src);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i < adjList.get(curr).size(); i++){
                int neighbour = adjList.get(curr).get(i);
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    parent[neighbour] = curr;
                    queue.add(neighbour);
                }
                if (parent[curr] != neighbour) return true;
            }
        }
        return false;
    }

    // Cycle detection in directed graph.(this solution uses dfs).
    public boolean detectCycle3(int src){
        boolean[] visited = new boolean[vertices];
        boolean[] path = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if(detectCycle3(i, visited, path)) return true;
            }
        }
        return false;
    }
    private boolean detectCycle3(int src, boolean[] visited, boolean[] path){
        visited[src] = true;
        path[src] = true;
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int curr = adjList.get(src).get(i);
            if (path[curr]) return true;
            if (!visited[curr]) if (detectCycle3(curr, visited, path)) return true;
        }
        path[src] = false;
        return false;
    }

    // this method implements topological sort but has high time complexity and different from standard aproaches.
    public void TopologicalSort() {
        boolean[] visited = new boolean[vertices];
        boolean[] v = new boolean[vertices];

        int a = 0;
        while (a < vertices) {
            for (int i = 0; i < adjList.size(); i++) {
                for (int j = 0; j < adjList.get(i).size(); j++) {
                    if (a == adjList.get(i).get(j)) {
                        v[adjList.get(i).get(j)] = true;
                    }
                }
            }
            a++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (!v[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            for (int i = 0; i < adjList.get(curr).size(); i++) {
                ArrayList<Integer> parents = new ArrayList<>();
                int neighbour = adjList.get(curr).get(i);
                for (int j = 0; j < adjList.size(); j++) {
                    for (int k = 0; k < adjList.get(j).size(); k++) {
                        if (adjList.get(j).get(k) == neighbour) {
                            parents.add(j);
                        }
                    }
                }
                if (!visited[neighbour] && AllParentsVisited(parents, visited)) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        System.out.println(list);
    }

    private boolean AllParentsVisited(ArrayList<Integer> parents, boolean[] visited){
       for(int i = 0; i < parents.size(); i++){
           if (!visited[parents.get(i)]) return false;
       }
       return true;
    }

    // this method is one of the standard approaches for Topological sorting known as kahn's algorithm.
    public void TopologicalSort2(){
        int[] indegree = new int[vertices];
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                indegree[adjList.get(i).get(j)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            for (int i = 0; i < adjList.get(curr).size(); i++) {
                int neighbour = adjList.get(curr).get(i);
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) queue.add(neighbour);
            }
        }
        System.out.println(list);
    }

    // this method is also one of the standard approaches for Topological sorting known as DFS approach.
    public void TopologicalSort3(){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) dfs(i, stack, visited);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            list.add(curr);
        }
        System.out.println(list);
    }
    private void dfs(int src, Stack<Integer> stack, boolean[] visited){
        visited[src] = true;
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int neighbour = adjList.get(src).get(i);
            if (!visited[neighbour]) dfs(neighbour, stack, visited);
        }
        stack.push(src);
    }
}

class Graph2{
    private int vertices;
    private int[][] arr;

    public Graph2(int v){
        this.vertices = v;
        arr = new int[vertices][vertices];
    }

    public void addEdge(int u ,int v){
        if (u >= 0 && u < vertices && v >= 0 && v < vertices){
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        else {
            System.out.println("invalid vertex");
        }
    }

    public void printGraph(){
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

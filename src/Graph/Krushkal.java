package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Krushkal {
    static class Edge {
        int from;
        int to;
        int weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public List<Edge> getAllEdges(UndirectedWeightedGraph graph){
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.adjList.size(); i++) {
            for (int j = 0; j < graph.adjList.get(i).size(); j++) {
                UndirectedWeightedGraph.Edge ed = graph.adjList.get(i).get(j);
                if (i < ed.to) edges.add(new Edge(i, ed.to, ed.weight));
            }
        }
        return edges;
    }
    // This method uses dijoint set to find cycle. (this is more optimized)
    public int FindMST(UndirectedWeightedGraph graph){
        List<Edge> graphEdges = getAllEdges(graph);
        List<Edge> mstEdges = new ArrayList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.addAll(graphEdges);

        DisjointSet dsu = new DisjointSet(graph.V);

        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;

            if (dsu.find(from) != dsu.find(to)){
                dsu.union(from, to);
                mstEdges.add(edge);
            }

            if (mstEdges.size() == graph.V - 1) break;
        }

        int totalweight = 0;
        for (int i = 0; i < mstEdges.size(); i++) {
            Edge edge = mstEdges.get(i);
            totalweight = totalweight + edge.weight;
        }
        return totalweight;
    }

    // This method uses dfs cycle detection to find cycle.
    public int FindMST1(UndirectedWeightedGraph graph){
        List<Edge> graphEdges = getAllEdges(graph);
        List<Edge> mstEdges = new ArrayList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.addAll(graphEdges);

        UndirectedWeightedGraph g = new UndirectedWeightedGraph(graph.adjList.size());
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            int weight = edge.weight;

            g.addEdge(from, to, weight);

            if (detectCycle(g)) g.removeEdge(from, to);
            else mstEdges.add(edge);

            if (mstEdges.size() == graph.V - 1) break;
        }

        int totalweight = 0;
        for (int i = 0; i < mstEdges.size(); i++) {
            Edge edge = mstEdges.get(i);
            totalweight = totalweight + edge.weight;
        }
        return totalweight;
    }

    public boolean detectCycle(UndirectedWeightedGraph g){
        boolean[] visited = new boolean[g.V];
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) if(detectCycle(g, i, visited, -1)) return true;
        }
        return false;
    }
    public boolean detectCycle(UndirectedWeightedGraph g, int src, boolean[] visited, int parent){
        visited[src] = true;
        for (int i = 0; i < g.adjList.get(src).size(); i++) {
            int curr = g.adjList.get(src).get(i).to;
            if (visited[curr] && curr != parent) return true;
            if (!visited[curr]){
                if(detectCycle(g, curr, visited, src)) return true;
            }
        }
        return false;
    }

}

class UndirectedWeightedGraph {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    ArrayList<ArrayList<Edge>> adjList;
    int V;

    UndirectedWeightedGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight));
    }

    public void removeEdge(int u, int v) {
        adjList.get(u).removeIf(e -> e.to == v);
        adjList.get(v).removeIf(e -> e.to == u);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                Edge curr = adjList.get(i).get(j);
                System.out.println(i + " -> " + curr.to + " : " + curr.weight);
            }
        }
    }
}
package Graph;

import java.util.*;

public class Dijkstra {
    // This method provides shortest path from src to dst using Dijkstra Algorithm.
    static class Pair{
        int node;
        int w;
        Pair(int node,int w){
            this.node = node;
            this.w = w;
        }
    }
    public int[] ShortestPath(DirectedWeightedGraph dp, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Pair(src, 0));
        int[] dist = new int[dp.V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!pq.isEmpty()){
            Pair currvertex =  pq.poll();
            int currNode = currvertex.node;
            int weight = currvertex.w;
            if (weight > dist[currNode]) continue;
            for (int i = 0; i < dp.adjList.get(currNode).size(); i++) {
                DirectedWeightedGraph.Edge curr = dp.adjList.get(currNode).get(i);
                int next = curr.to;
                int newweight = weight + curr.weight;
                if (newweight < dist[next]) {
                    dist[next] = newweight;
                    pq.offer(new Pair(next, newweight));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args){
        DirectedWeightedGraph dg = new DirectedWeightedGraph(6);
        dg.addEdge(0,1,2);
        dg.addEdge(0,2,4);
        dg.addEdge(1,2,1);
        dg.addEdge(1,3,7);
        dg.addEdge(2,4,3);
        dg.addEdge(3,5,1);
        dg.addEdge(4,3,2);
        dg.addEdge(4,5,5);

        dg.printGraph();

        Dijkstra dij = new Dijkstra();

        int[] ans = dij.ShortestPath(dg, 0);

        System.out.println("Shortest Path : " + Arrays.toString(ans));
    }
}

class DirectedWeightedGraph{
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    ArrayList<ArrayList<Edge>> adjList;
    int V;
    DirectedWeightedGraph(int V){
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from,int to,int weight){
        adjList.get(from).add(new Edge(to, weight));
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            for(int j = 0; j < adjList.get(i).size(); j++){
                Edge curr = adjList.get(i).get(j);
                System.out.println(i + " -> " + curr.to + " : " + curr.weight);
            }
        }
    }
}
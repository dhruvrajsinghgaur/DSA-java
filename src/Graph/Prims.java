package Graph;

import java.util.*;

public class Prims {
    static class Pair{
        int to;
        int weight;
        public Pair(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public int findMST(UndirectedWeightedGraph graph){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.weight - b.weight));
        boolean[] visited = new boolean[graph.adjList.size()];
        int totalWeight = 0;
        int usedEdges = 0;
        pq.offer(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int to = p.to;
            int weight = p.weight;

            if(visited[to]) continue;

            visited[to] = true;
            totalWeight += weight;
            usedEdges++;

            if (usedEdges == graph.V) break;

            for (int i = 0; i < graph.adjList.get(to).size(); i++) {
                UndirectedWeightedGraph.Edge neighbour = graph.adjList.get(to).get(i);
                if(!visited[neighbour.to]) pq.offer(new Pair(neighbour.to, neighbour.weight));
            }
        }
        return totalWeight;
    }
}

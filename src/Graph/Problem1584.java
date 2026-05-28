package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem1584 {
    static class Edge {
        int p1;
        int p2;
        int weight;

        public Edge(int p1, int p2, int weight) {
            this.p1 = p1;
            this.p2 = p2;
            this.weight = weight;
        }
    }

    static class P{
        int point;
        int weight;
        public P(int point, int weight){
            this.point = point;
            this.weight = weight;
        }
    }
    public static int minCostConnectPoints(int[][] points){
        PriorityQueue<P> pq = new PriorityQueue<>((a,b)->a.weight - b.weight);
        boolean[] visited = new boolean[points.length];
        int totalWeight = 0;
        int usedEdges = 0;
        pq.offer(new  P(0, 0));
        while(!pq.isEmpty()){
             P pair = pq.poll();
             int point = pair.point;
             int weight = pair.weight;

             if (visited[point]) continue;

            visited[point] = true;
            totalWeight += weight;
            usedEdges++;

            if (usedEdges == points.length) break;

            for(int i = 0; i < points.length; i++){
                if(visited[i]) continue;
                int x = Math.abs(points[point][0] - points[i][0]);
                int y = Math.abs(points[point][1]  - points[i][1]);
                pq.offer(new P(i, x + y));
            }
        }
        return totalWeight;
    }

    public static int minCostConnectPoints1(int[][] points){
        ArrayList<ArrayList<Prims.Pair>> graphList = EdgeCreationFromPoints1(points);
        PriorityQueue<Prims.Pair> pq = new PriorityQueue<>((a, b)->(a.weight - b.weight));
        boolean[] visited = new boolean[graphList.size()];
        int totalWeight = 0;
        int usedEdges = 0;
        pq.offer(new Prims.Pair(0, 0));
        while(!pq.isEmpty()){
            Prims.Pair p = pq.poll();
            int to = p.to;
            int weight = p.weight;

            if(visited[to]) continue;

            visited[to] = true;
            totalWeight += weight;
            usedEdges++;

            if (usedEdges == points.length) break;

            for (int i = 0; i < graphList.get(to).size(); i++) {
                Prims.Pair neighbour = graphList.get(to).get(i);
                if(!visited[neighbour.to]) pq.offer(new Prims.Pair(neighbour.to, neighbour.weight));
            }
        }
        return totalWeight;
    }

    private static ArrayList<ArrayList<Prims.Pair>> EdgeCreationFromPoints1(int[][] points){
        ArrayList<ArrayList<Prims.Pair>> adjlist = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            adjlist.add(new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x = Math.abs(p1[0] - p2[0]);
                int y = Math.abs(p1[1] - p2[1]);
                int weight = x + y;
                adjlist.get(i).add(new Prims.Pair(j, weight));
                adjlist.get(j).add(new Prims.Pair(i, weight));
            }
        }
        return adjlist;
    }
    public static int minCostConnectPoints2(int[][] points) {
        PriorityQueue<Edge> pq = EdgeCreationFromPoints2(points);
        int ans = Mst(pq, points.length);
        return ans;
    }

    private static PriorityQueue<Edge> EdgeCreationFromPoints2(int[][] points){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b )-> a.weight - b.weight);
        for (int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x = Math.abs(p1[0] - p2[0]);
                int y = Math.abs(p1[1] - p2[1]);
                pq.offer(new Edge(i, j, x + y));
            }
        }
        return pq;
    }

    private static int Mst(PriorityQueue<Edge> pq, int n){
        int totalweight = 0;
        DisjointSet dsu  = new DisjointSet(n);
        int usedEdges = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int p1 = edge.p1;
            int p2 = edge.p2;
            int weight = edge.weight;

            if (dsu.find(p1) != dsu.find(p2)){
                dsu.union(p1, p2);
                totalweight += weight;
                usedEdges++;
            }

            if (usedEdges == n - 1) break;
        }
        return totalweight;
    }

    public static void main(String[] args){
        int[][] points = { {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0}
        };
        ArrayList<ArrayList<Prims.Pair>> ans = EdgeCreationFromPoints1(points);

        int mst = minCostConnectPoints(points);
        System.out.println(mst);

        for(int i = 0; i < ans.size(); i++){
            System.out.print("[ ");
            for(int j = 0; j < ans.get(i).size(); j++){
                Prims.Pair edge = ans.get(i).get(j);
                System.out.print("From " + i + " -> " + "To " + edge.to + " : Weight " + edge.weight);
                if(j != ans.get(i).size() - 1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

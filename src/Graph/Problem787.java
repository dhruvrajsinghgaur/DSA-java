package Graph;

import java.util.*;

public class Problem787 {

 //This is an DFS approach but it gives TLE on leetCode (logically its correct but Time complexity is poor)

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Integer> priceList = new ArrayList<>();
        dfs(flights, src, dst, k, 0, priceList);
        if  (priceList.size() == 0) return -1;
        int minValueInList = Integer.MAX_VALUE;
        for (int i = 0; i < priceList.size(); i++) {
            if (priceList.get(i) < minValueInList) minValueInList = priceList.get(i);
        }
        return minValueInList;
    }
    private void dfs(int[][] flights, int src, int dst, int k, int prize, ArrayList<Integer> priceList) {
        if (src == dst && k >= -1) {
            priceList.add(prize);
            return;
        }
        if  (k <= -1) return;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i][0] == src) {
                dfs(flights, flights[i][1], dst, k-1, prize + flights[i][2], priceList);
            }
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        int price = 0;
        int stops = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            int[] temp = dist.clone();
            while (size-- > 0) {
                int[] curr = queue.poll();
                price = curr[1];
                for (int i = 0; i < flights.length; i++) {
                    if (flights[i][0] == curr[0]) {
                        int next = flights[i][1];
                        int newCost = price + flights[i][2];
                        if (newCost < temp[next]) {
                            temp[next] = newCost;
                            queue.add(new int[]{next, newCost});
                        }
                    }
                }
            }
            dist = temp;
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int[][] flights = {
                {0,12,28},{5,6,39},{8,6,59},{13,15,7},{13,12,38},{10,12,35},
                {15,3,23},{7,11,26},{9,4,65},{10,2,38},{4,7,7},{14,15,31},
                {2,12,44},{8,10,34},{13,6,29},{5,14,89},{11,16,13},{7,3,46},
                {10,15,19},{12,4,58},{13,16,11},{16,4,76},{2,0,12},{15,0,22},
                {16,12,13},{7,1,29},{7,14,100},{16,1,14},{9,6,74},{11,1,73},
                {2,11,60},{10,11,85},{2,5,49},{3,4,17},{4,9,77},{16,3,47},
                {15,6,78},{14,1,90},{10,5,95},{1,11,30},{11,0,37},{10,4,86},
                {0,8,57},{6,14,68},{16,8,3},{13,0,65},{2,13,6},{5,13,5},
                {8,11,31},{6,10,20},{6,2,33},{9,1,3},{14,9,58},{12,3,19},
                {11,2,74},{12,14,48},{16,11,100},{3,12,38},{12,13,77},{10,9,99},
                {15,13,98},{15,12,71},{1,4,28},{7,0,83},{3,5,100},{8,9,14},
                {15,11,57},{3,6,65},{1,3,45},{14,7,74},{2,10,39},{4,8,73},
                {13,5,77},{10,0,43},{12,9,92},{8,2,26},{1,7,7},{9,12,10},
                {13,11,64},{8,13,80},{6,12,74},{9,7,35},{0,15,48},{3,7,87},
                {16,9,42},{5,16,64},{4,5,65},{15,14,70},{12,0,13},{16,14,52},
                {3,10,80},{14,11,85},{15,2,77},{4,11,19},{2,7,49},{10,7,78},
                {14,6,84},{13,7,50},{11,6,75},{5,10,46},{13,8,43},{9,10,49},
                {7,12,64},{0,10,76},{5,9,77},{8,3,28},{11,9,28},{12,16,87},
                {12,6,24},{9,15,94},{5,7,77},{4,10,18},{7,2,11},{9,5,41}
        };

        int src = 13;
        int dst = 4;
        int k = 13;
        int n = 17;

        Problem787 p = new Problem787();

        System.out.println(p.findCheapestPrice1(n, flights, src, dst, k));
    }
}

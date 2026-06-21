package Heaps;

import java.util.*;

public class LC_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap =
                new PriorityQueue<>(
                        Comparator.comparingDouble((double[] a) -> a[2]).reversed()
                );
        for (int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = (long)x*x + (long)y*y;
            double[] point = new double[3];
            point[0] = x;
            point[1] = y;
            point[2] = dist;
            maxHeap.offer(point);

            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] answers = new int[k][2];
        for (int i = 0; i < maxHeap.size(); i++) {
            double[] ans = maxHeap.poll();
            answers[i][0] = (int) ans[0];
            answers[i][1] = (int) ans[1];
        }
        return answers;
    }
}

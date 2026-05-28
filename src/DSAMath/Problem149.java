package DSAMath;

import java.util.Collections;
import java.util.HashMap;
public class Problem149 {
    public static void main(String[] args){
        int[][] arr1 = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] arr2 = {{4,5},{4,-1},{4,0}};
        int[][] arr3 = {{9,-25},{-4,1},{-1,5},{-7,7}};
        int[][] arr4 = {{0,0}};
        int ans = maxPoints(arr4);
        System.out.println(ans);
    }
    public static int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        HashMap<Double,Integer> map = new HashMap<>();
        if (XisSame(points) || YisSame(points)) return points.length;
        int maxvalue = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i==j) continue;
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dx = x2 - x1;
                int dy = y2 - y1;

                double theta = Math.atan2(dy, dx);

                map.put(theta, map.getOrDefault(theta, 0) + 1);
            }
            int max = 0;
            if (!map.isEmpty()) max = Collections.max(map.values());
            if (max>maxvalue) maxvalue = max;
            map.clear();
        }
        return maxvalue + 1;
    }

    public static boolean XisSame(int[][] points){
        for (int i = 1; i < points.length; i++) {
            if (points[i-1][0] != points[i][0]) return false;
        }
        return true;
    }
    public static boolean YisSame(int[][] points){
        for (int i = 1; i < points.length; i++) {
            if (points[i-1][1] != points[i][1]) return false;
        }
        return true;
    }
}
package Patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return intervals;
        if (intervals.length == 0) return new int[][]{newInterval};
        int[][] newIntervals = new int[intervals.length + 1][2];
        int breakPoint = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                newIntervals[i] = newInterval;
                newIntervals[i + 1] = intervals[i];
                breakPoint = i + 1;
                break;
            } else {
                newIntervals[i] = intervals[i];
            }
        }
        if (breakPoint == -1) {
            for (int i = 0; i < newIntervals.length; i++) {
                if (i == intervals.length) newIntervals[i] = newInterval;
                else newIntervals[i] = intervals[i];
            }
        }
        else {
            for (int i = breakPoint; i < intervals.length; i++) newIntervals[i + 1] = intervals[i];
        }

        List<int[]> list = new ArrayList<>();
        int[] comparator = newIntervals[0];
        for (int i = 1; i < newIntervals.length; i++) {
            if (newIntervals[i][0] <= comparator[1]) {
                comparator[1] = Math.max(newIntervals[i][1], comparator[1]);
            } else {
                list.add(comparator);
                comparator = newIntervals[i];
            }
        }
        list.add(comparator);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    void main(){
        int[][] arr = {
                {1, 5}
        };

        int[] newInterval = {2, 7};

        int[][] ans = insert(arr, newInterval);

        System.out.print("[ ");
        for (int i = 0; i < ans.length; i++) {
            if (i < ans.length - 1) System.out.print(Arrays.toString(ans[i]) + ", ");
            else System.out.print(Arrays.toString(ans[i]));
        }
        System.out.print(" ]");
        System.out.println();
    }
}

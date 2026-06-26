package Patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] comparator = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= comparator[1]) {
                comparator[1] = intervals[i][1] > comparator[1] ? intervals[i][1] : comparator[1];
            } else {
                list.add(comparator);
                comparator = intervals[i];
            }
        }
        list.add(comparator);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

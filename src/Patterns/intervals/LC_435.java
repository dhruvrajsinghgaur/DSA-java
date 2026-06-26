package Patterns.intervals;

import java.util.Arrays;

public class LC_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            if (currentStart < prevEnd) removed++;
            else prevEnd = intervals[i][1];
        }
        return removed;
    }
}

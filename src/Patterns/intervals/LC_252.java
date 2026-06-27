package Patterns.intervals;

import java.util.Arrays;

public class LC_252 {
    public boolean canAttendAllMeetings(int[][] meetings){
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) return false;
        }
        return true;
    }
}

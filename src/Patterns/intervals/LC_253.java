package Patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_253 {

    // Method 0
    // TC: O(n logn)
    public int roomsRequiredForMeetings(int[][] meetings){
        if (meetings.length == 0) return 0;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        rooms.offer(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            if (rooms.peek()[1] > meetings[i][0]){
                rooms.offer(meetings[i]);
            } else {
                rooms.poll();
                rooms.offer(meetings[i]);
            }
        }
        return rooms.size();
    }

    // Method 1. (it uses standard Start Time to sort meetings arr)
    // TC: O(n^2) in worst case.
    public int roomsRequiredForMeetings1(int[][] meetings){
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> rooms = new ArrayList<>();
        rooms.add(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            int index = isRoomFree(rooms, meetings[i]);
            if (index == -1){
                rooms.add(meetings[i]);
            } else {
                rooms.get(index)[1] = Math.max(rooms.get(index)[1], meetings[i][1]);
            }
        }

        return rooms.size();
    }

    // Method 2. (it does not sort meetings arr according to the standard Start Time instead it uses End Time which according to me is correct)
    // TC: O(n^2) in worst case.
    public int roomsRequiredForMeetings2(int[][] meetings){
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> rooms = new ArrayList<>();
        rooms.add(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            int index = isRoomFree(rooms, meetings[i]);
            if (index == -1){
                rooms.add(meetings[i]);
            } else {
                rooms.get(index)[1] = Math.max(rooms.get(index)[1], meetings[i][1]);
            }
        }

        return rooms.size();
    }
    public int isRoomFree(List<int[]> rooms, int[] meeting){
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i)[1] <= meeting[0]) return i;
        }
        return -1;
    }
}

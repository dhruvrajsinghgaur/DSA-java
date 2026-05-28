package LargeNumbers;

import java.util.ArrayList;

public class Problem1649 {

    // This solution gives TLE.
    public int createSortedArray(int[] instructions) {
        ArrayList<Integer> nums = new ArrayList<>();
        int cost = 0;
        for(int i = 0; i < instructions.length; i++){
            int curr = instructions[i];
            cost = cost + Math.min(minThanElement(curr, nums), maxThanElement(curr, nums));
            nums.add(curr);
        }
        return cost % 1000000007;
    }
    private int minThanElement(int element, ArrayList<Integer> list){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i) < element) count++;
        }
        return count;
    }
    private int maxThanElement(int element, ArrayList<Integer> list){
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if (list.get(i) > element) count++;
        }
        return count;
    }
}

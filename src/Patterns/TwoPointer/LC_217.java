package Patterns.TwoPointer;

import java.util.HashMap;

public class LC_217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}

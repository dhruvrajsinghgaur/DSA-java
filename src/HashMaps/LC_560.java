package HashMaps;

import java.util.HashMap;

public class LC_560 {
    
    public int subarraySum(int[] nums, int k){
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int requiredPrefix = prefixSum[i] - k;

            if (map.containsKey(requiredPrefix)) {
                count = count + map.getOrDefault(requiredPrefix, 0);
            }

            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
    public int subarraySum1(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i -1] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int subArraySum;
                if (i == 0) subArraySum = prefixSum[j];
                else subArraySum = prefixSum[j] - prefixSum[i - 1];
                if (subArraySum == k) count++;
            }
        }
        return count;
    } 
}

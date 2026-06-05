package HashMaps;

import java.util.*;

public class LC_347 {

    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1 );
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        List<Integer> keys = new ArrayList<>(freqMap.keySet());

        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            int freq = freqMap.get(key);

            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();

            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int freq = bucket.length - 1; freq >= 0 && index < k; freq--) {

            if (bucket[freq] != null){
                for (int i = 0; i < bucket[freq].size(); i++) {
                    result[index] = bucket[freq].get(i);
                    index++;
                }
            }
        }
        return result;
    }

    public int[] topKFrequent1(int[] nums, int k){
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        for (int i = 0; i < countMap.size(); i++) {
            pq.offer(keys.get(i));
        }

        int[] max = new int[k];
        for (int i = 0; i < k; i++) {
            max[i] = pq.poll();
        }
        return max;
    }
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.getOrDefault(nums[i], 0) + 1);
        }

        int[] max = new int[k];
        int maxNum = 0;
        for (int i = 0; i < k; i++) {
            int maxCount = 0;
            for (int j = 0; j < nums.length; j++) {
                int current = countMap.getOrDefault(nums[j], 0);
                if (current > maxCount) {
                    maxCount = current;
                    maxNum = nums[j];
                }
            }
            max[i] = maxNum;
            countMap.remove(maxNum);
        }

        return max;
    }

    void main(){
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent1(nums, 2)));
    }
}

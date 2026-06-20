package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_215 {

    // Method 1.
    // TC: O(NlogK).
    // SC: O(K).
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums){
            minHeap.offer(num);

            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    // Methos 2.
    // TC: O((N+K)logN).
    // SC: O(N)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = maxHeap.poll();
        }
        return ans;
    }
}

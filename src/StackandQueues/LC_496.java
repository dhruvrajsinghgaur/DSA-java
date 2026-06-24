package StackandQueues;

import java.util.HashMap;
import java.util.Stack;

public class LC_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int[] arr = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            arr[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                arr[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                nums1[map.get(nums2[i])] = arr[i];
            }
        }
        return nums1;
    }
}

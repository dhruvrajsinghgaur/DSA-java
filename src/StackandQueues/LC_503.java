package StackandQueues;

import java.util.Stack;

public class LC_503 {

    // Method 1.
    // TC: O(n).
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < 2*nums.length; i++) {
            int index = i % nums.length;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                arr[stack.pop()] = nums[index];
            }
            if (i < nums.length){
                stack.push(index);
            }
        }
        return arr;
    }

    // Method 2.(same approach as method 1 just written a bit differently)
    // TC: O(n).
    public int[] nextGreaterElements1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        int counter = 0;
        for (int i = 0; i <= nums.length && counter <= 1; i++) {
            if (i == nums.length){
                i = 0;
                counter++;
            }
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                arr[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        return arr;
    }

    // Method 3.
    // TC: O(n^2).
    public int[] nextGreaterElements2(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if(j == nums.length) j = 0;
                if (j == i) break;
                if (nums[i] < nums[j]){
                    arr[i] = nums[j];
                    break;
                }
            }
        }
        return arr;
    }
}

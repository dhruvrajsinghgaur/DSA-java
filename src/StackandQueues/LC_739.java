package StackandQueues;

import java.util.Stack;

public class LC_739 {

    // Method 1.
    // TC: O(n).
    // SC: O(n).
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

    // Method 2. (on leetCode this method gives TLE)
    // TC: O(n^2).
    // SC: O(1).
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            int counter = 1;
            while (j < temperatures.length){
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = counter;
                    break;
                }
                counter++;
                j++;
            }
        }
        return ans;
    }
}

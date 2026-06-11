package StackandQueues;

import java.util.*;

public class LC_84 {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i <= n; i++){

            int curr = i == n ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] >= curr){
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

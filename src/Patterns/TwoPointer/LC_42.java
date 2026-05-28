package Patterns.TwoPointer;

import java.io.OutputStream;

public class LC_42 {
    public static int trap(int[] height) {
        int trapedWater = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxLeft) maxLeft = height[left];
                else {
                    trapedWater = trapedWater + maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) maxRight = height[right];
                else {
                    trapedWater = trapedWater + maxRight - height[right];
                }
                right--;
            }
        }
        return trapedWater;
    }

    public static int trap1(int[] height) {
        int maxTraped = 0;
        int pointer1 = 0;
        int pointer2 = 1;
        int peak = largestElement(height);
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        while (pointer2 < height.length){
            if (height[pointer2] >= height[pointer1]){
                pointer1 = pointer2;
                if (height[pointer1] == peak) {
                    int ans = trap1(revertHeights(height, pointer1));
                    return maxTraped + ans;
                }
                pointer2 = pointer1 + 1;
            }
            else {
                int effectiveWall = Math.min(height[pointer1], rightMax[pointer2]);
                int currentTrapped = effectiveWall - height[pointer2];
                maxTraped = maxTraped + currentTrapped;
                pointer2 = pointer2 + 1;
            }
        }
        return maxTraped;
    }

    private static int largestElement(int[] arr){
        int peak = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > peak) peak = arr[i];
        }
        return peak;
    }
    private static int[] revertHeights(int[] height, int pointer){
        int[] arr = new int[height.length - pointer];
        int j = height.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = height[j];
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},  // Test 1
                {3, 0, 5, 0, 4, 0, 3},                   // Test 2
                {3, 0, 3},                                // Test 3
                {5, 4, 3, 2, 1, 2, 3, 4, 5},             // Test 4
                {5},                                      // Test 5
                {4, 2, 3},                                // Test 6
                {1, 0, 1, 0, 1}                           // Test 7
        };
        int[] expected = {6, 10, 3, 16, 0, 1, 2};
        String[] names = {
                "Standard case",
                "Peak in middle with slopes",
                "Equal heights",
                "Descending then ascending",
                "Single bar",
                "Small case",
                "Multiple valleys"
        };

        int passed = 0;
        for (int i = 0; i < tests.length; i++) {
            int result = trap1(tests[i]);
            String status = result == expected[i] ? " PASS" : " FAIL";
            if (result == expected[i]) passed++;
            System.out.println("Test " + (i+1) + " [" + names[i] + "]");
            System.out.println("  Got: " + result + " | Expected: " + expected[i] + " | " + status);
        }
        System.out.println("\n" + passed + "/" + tests.length + " tests passed");
    }
}

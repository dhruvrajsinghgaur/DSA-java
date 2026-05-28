package Patterns.TwoPointer;
public class LC_11 {

    //Method 1.
    public int maxArea(int[] heights) {
        int left = 0;
        int right =  heights.length - 1;
        int maxArea = 0;
        while(left < right){
            if (heights[left] < heights[right]){
                int currentArea  =  heights[left] * (right - left);
                if(currentArea > maxArea) maxArea = currentArea;
                left++;
            }
            else if (heights[left] > heights[right]){
                int currentArea  =  heights[right] * (right - left);
                if(currentArea > maxArea) maxArea = currentArea;
                right--;
            }
            else if (heights[left] == heights[right]){
                int currentArea = heights[left] * (right - left);
                if(currentArea > maxArea) maxArea = currentArea;
                left++;
                right--;
            }
        }
        return maxArea;
    }

    //Method 2.
    public int maxArea1(int[] heights) {
        int left = 0;
        int right =  heights.length - 1;
        int maxArea = 0;
        while(left < right){
            if (heights[left] < heights[right]){
                int currentArea  =  heights[left] * (right - left);
                if(currentArea > maxArea) maxArea = currentArea;
                left++;
            } else {
                int currentArea = heights[right] * (right - left);
                if(currentArea > maxArea) maxArea = currentArea;
                right--;
            }
        }
        return maxArea;
    }
}

package BS;

import java.util.PriorityQueue;

public class Problem4 {

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        int[] arr3 = {3,4};
        int[] arr4 = {1,2};
        System.out.println(findMedianSortedArrays1(arr4, arr3));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length < 1)&&(nums2.length < 1)) return 0;
        int[] nums = new int[nums1.length + nums2.length];
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start)/2;

        double median = 0.0;
        if (nums.length%2==0) median =  (nums[mid] + nums[mid+1])/2;
        else median =  (nums[mid]);
        return median;
    }

    // this is good but does not solve the question in the required time and space complexity and also does not use the required algo.
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if((nums1.length < 1)&&(nums2.length < 1)) return 0;
        int[] nums = new  int[nums1.length + nums2.length];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        //Heap<Integer>  minheap = new Heap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < nums1.length) minheap.add(nums1[i]);
            else minheap.add(nums2[i-nums1.length]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = minheap.poll();
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start)/2;
        double median = 0.0;
        if (nums.length%2==0) median =  (nums[mid] + nums[mid+1])/(double)2;
        else median =  (nums[mid]);
        return median;
    }
}

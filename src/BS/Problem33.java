package BS;

public class Problem33 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        //System.out.println(findMin(arr));
        System.out.println(search(arr,0));
    }
    public static int search(int[] nums, int target) {
        int start = 0;
        int start2 = findMin(nums);
        int end = nums.length - 1;

        int index1 = Bs(nums, start, start2-1, target);
        int index2 = Bs(nums, start2, end, target);

        if (index1 != -1) return index1;
        else return index2;
    }
    private static int Bs(int[] nums, int start, int end, int target){
        if (nums.length == 0 || nums == null) return -1;
        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid-1;
            if (nums[mid] < target) start = mid + 1;
        }
        return -1;
    }
    private static int findMin(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        if (arr[start] <= arr[end]) return start;
        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]) return mid + 1;
            if (arr[mid] < arr[end]) end = mid;
            else start = mid+1;
        }
        return start;
    }
}

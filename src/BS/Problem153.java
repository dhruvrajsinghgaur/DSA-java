package BS;

public class Problem153 {
    // this method uses loops and raw binary search logic because of that time complexity is O(logn).
    public int findMin(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        if (arr[start] <= arr[end]) return arr[start];
        while(start <= end){
            mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]) return arr[mid + 1];
            if (arr[mid] < arr[end]) end = mid;
            else start = mid+1;
        }
        return arr[start];
    }
    // this method uses recursion because of that time complexity is O(n).
    public int findMin1(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        int indexvalue = helper(arr, start, end) + 1;
        if (indexvalue < arr.length) return arr[indexvalue];
        else return arr[0];
    }
    private int helper(int[] arr, int start, int end){
        if (start >= end) return -1;
        int mid = start + (end - start)/2;
        if (arr[mid] > arr[mid+1]) return mid;
        int leftarr = helper(arr, start, mid);
        int rightarr = helper(arr, mid+1, end);
        if (leftarr != -1) return leftarr;
        else return rightarr;
    }
}

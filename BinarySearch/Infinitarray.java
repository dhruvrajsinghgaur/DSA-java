

public class Infinitarray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 20;
        System.out.println(ans(arr, target));
        
    }
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;
        // Find the range where the target might be present
        while(target > get(arr,end)){
            int newstart = end +1;
            int newend = end + (end - start +1)*2; // Double the range
            start = newstart;
            end = newend;
        }
       
        return binarysearch(arr, target, start, end);
    }
     static int binarysearch(int[] arr ,int target,int start,int end){
        if(arr == null || arr.length ==0){
            return -1; // Array is empty or null
        }
        
        while(start <= end){
            int mid = start+ (end-start) /2;
            if(arr[mid] > target){
                end = mid-1; // Target is in the left half
            } 
            else if(arr[mid]< target){
                start = mid+1; // Target is in the right half
            }
            else {
                return mid; // Target found at index mid
            }
            }
      return -1; // Target not found in the array}
    }
    static int get(int[] arr, int index) {
       if(index>=arr.length){
           return Integer.MAX_VALUE; // Simulating infinite array
           }
           return arr[index]; // Return the value at the given index
    }
}

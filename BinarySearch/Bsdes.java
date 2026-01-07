public class Bsdes {
    public static void main(String[] args) {
        int nums[] = {9,8,7,6,5,4,3,2,1};
        int target = 5;
        int empty[] = {};

        System.out.println(binarysearch(nums, target));
        System.out.println(binarysearch(empty, target));
        
    }
    static int binarysearch(int[] arr ,int target){
        if(arr == null || arr.length ==0){
            return -1; // Array is empty or null
        }
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start+ (end-start) /2;
            if(arr[mid] > target){
                start = mid+1;
            } 
            else if(arr[mid]< target){
               end = mid-1;
            }
            else {
                return mid; // Target found at index mid
            }
            }
      return -1; // Target not found in the array}
    }
}


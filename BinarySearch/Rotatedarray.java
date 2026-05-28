public class Rotatedarray {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int pivot = searchpivot(arr);
       if (pivot == -1){
            binarysearch(arr, target, 0,  arr.length - 1);// Array is not rotated
        }
        if(arr[pivot]==target){
            System.out.println("Target found at index: " + pivot);
        }
        if(target>=arr[0]){
           System.out.println( binarysearch(arr, target, 0, pivot-1));
        }
        if(target<= arr[arr.length - 1]){
            System.err.println(binarysearch(arr, target, pivot + 1, arr.length - 1));
        }
       
        
    }
    static int searchpivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if (arr[mid]>arr[mid+1]) {
                return mid;
            }
            if(arr[mid]<arr[mid-1]){
                return mid - 1;
            }
            if(arr[mid]<= arr[start]){
                end = mid - 1;

            }
            if (arr[mid]> arr[start]){
                start =mid + 1;
            }
        }

    return -1; 
    }
    static int binarysearch(int[] arr ,int target,int start, int end){
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
}

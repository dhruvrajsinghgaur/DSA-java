public class Problem1095 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 5, 3, 2, 1};
        int target = 3;
        int peak = findPeakElement(arr);
        int firsttry = binarysearch1(arr, target,0,peak);
        int secondtry = binarysearch2(arr, target,peak,arr.length - 1);
        if(firsttry != -1){
            System.out.println("Target found at index: " + firsttry);
        } else if(secondtry  != -1){
            System.out.println("Target found at index: " + secondtry);
        }
        else {
            System.out.println("Target not found in the array");
        }
    }
     static int findPeakElement(int[] arr){
        if(arr == null || arr.length == 0){
            return -1; // Array is empty or null
        }
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
             int mid = start + (end - start)/2;
            // Check if mid is a peak element
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }
          else if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            
        }
       
          
        }
          return start ; 
}
static int binarysearch1(int[] arr ,int target,int start,int end){
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
  static int binarysearch2(int[] arr ,int target,int start,int end){
        if(arr == null || arr.length ==0){
            return -1; // Array is empty or null
        }
       
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

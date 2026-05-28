public class Peakelement {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(findPeakElement(nums));
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
}

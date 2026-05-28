public class PivotDuplicate {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int pivot = searchpivotwithduplicate(arr);
        int rotations = pivot + 1; // Number of rotations is pivot index + 1
        if (pivot == -1) {
            System.out.println("No pivot found");
        } else {
            System.out.println("Pivot found at index: " + pivot);
        }
        System.out.println("Number of rotations: " + rotations);
    }
      static int searchpivotwithduplicate(int[] arr){
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
          if (arr[mid] == arr[start]&& arr[mid] == arr[end]){
                // If duplicates are present, we cannot determine the pivot
                // We can skip the first and last elements
              if(arr[start]>arr[start+1]){
                    return start;
              }
              start++;
                
              if(arr[end]<arr[end-1]){
                        return end - 1;
                }
                end--;
             if (arr[mid] > arr[start] || (arr[mid] == arr[start] && arr[mid]>arr[end]) ) {
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
                
        }
        
    }
    return -1;

       }
    }
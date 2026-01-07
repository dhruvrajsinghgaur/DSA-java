public class Firstlastoccur {
    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9};
        int target = 4;
        int[] result = firstAndLastOccurrence(nums, target);

        System.out.println("First and last occurence: [" +  result[0]+","+ result[1]+"]");
        
    }
    static int foccurence(int[] arr ,int target){
        if(arr == null || arr.length ==0){
            return -1; // Array is empty or null
        }
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start+ (end-start) /2;
            if(arr[mid] == target){
                ans = mid; // Potential first occurrence
                end = mid-1; 
            } 
            else if(arr[mid] < target){
                start = mid+1; 
            }
          else{
                end = mid-1;}
            }
      return ans; 
    }
    
    static int loccurence(int[] arr ,int target){
        if(arr == null || arr.length ==0){
            return -1; // Array is empty or null
        }
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start+ (end-start) /2;
            if(arr[mid] == target){
                ans = mid; // Potential last occurrence
                start = mid+1;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
          else{
                end = mid-1;}
            }
      return ans;
    }
    static int[] firstAndLastOccurrence(int[] arr, int target) {
        int first = foccurence(arr, target);
        int last = loccurence(arr, target);
        
        return new int[]{first,last}; // Return both occurrences as a string
    }
}

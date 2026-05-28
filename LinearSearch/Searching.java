

public class Searching {
    public static void main(String[] args){
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int empty[] = {}; 
       
        System.out.println(linear(nums, 5,0,nums.length));
    }
     static String linear(int arr[], int x,int start, int end) {
        // Linear Search Algorithm
        if (arr == null || arr.length == 0) {
            return "Array is empty or null";
            }
      for(int i = 0;i<arr.length;i++){
            if(arr[i] == x){
                return "Element found at index " + i; // Element found at index i
            }
          
        }
      
       return "Element not found"; // Element not found
       }
      
}

public class Minnum {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 8, 2};
        System.out.println("Minimum number in the array: " + findmin(nums));
    }
    static String findmin(int[] arr){
        if(arr == null ||arr.length == 0){
            return "Array is empty or null";
        }
        int min = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(min>arr[i]){
                 min = arr[i];
                return "Minimum number in the array is: " + min; // Minimum number found
            }
        }
        return "Minimum number not found"; // Minimum number not found   
    }
}

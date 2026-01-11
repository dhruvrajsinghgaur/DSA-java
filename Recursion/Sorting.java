public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sort2(arr));
    }

    // Method 1
    public static int sort1(int[] arr){
        return helper1(arr,0);
    }
   private static int helper1(int[] arr, int i){
    if(i >= arr.length-1){
        return 1; //true
    }
    if(arr[i] < arr[i+1]){
        return helper1(arr, i+1);
    }
    return 0; //false
       
    }

    // Method 2
     public static boolean sort2(int[] arr){
        return helper2(arr,0);
    }
   private static boolean helper2(int[] arr, int i){
    if(i >= arr.length-1){
        return true;
    }
   
    return arr[i] < arr[i+1] && helper2(arr, i+1);
       
    }

}

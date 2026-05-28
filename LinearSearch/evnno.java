
public class evnno {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int count = findnum(nums);
        if (count != -1) {
            System.out.println("Total even numbers in the array: " + count);
           }
         else {
            System.out.println("Array is empty or null");
        }
       System.out.println(digit(count));
    }
    static int findnum(int[] arr){
        if(arr == null|| arr.length == 0){
            return -1; // Array is empty or null
        }
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(even(arr[i])==true){
                count++; // Increment count for each even number found
            }
        }
    return count; // Return the total count of even numbers
    }
    static boolean even(int num){
        if(digit(num)%2==0){
            return true; // Return true if the number of digits is even
        }
   return false; // Return false if the number of digits is odd
   }
    static int digit(int num){
        if(num < 0) {
            num = -num; // Convert negative number to positive
        }
        if(num == 0) {
            return 1; // Special case for zero, which has one digit
        }
        int count = 0;
        while(num>0){
            count++; // Increment count for each digit
            num=num/10; // Divide the number by 10 to remove the last digit
        }
        return count; // Return the total count of digits
        }
}

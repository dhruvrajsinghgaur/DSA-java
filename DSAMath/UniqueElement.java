
public class UniqueElement {
     public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 1, 2, 3};
      singledigit(arr);
     }
     static void singledigit(int[] arr){
       int unique = 0;
       for(int n : arr){
        unique = unique ^ n;  // can also be written as unique ^= n
       }
        
        System.out.println(unique);
      
     }
}

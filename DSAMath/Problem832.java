
import java.util.Arrays;


public class Problem832 {
    public static void main(String[] args) {
        int[][] arr = { {1, 1, 0, 1},
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {1, 0, 0, 1} };
        
        flipAndInvertImage(arr);
        
    }
     static int[][]flipAndInvertImage(int[][] arr){
      
        for (int i = 0; i <= arr.length-1; i++) {
          int s = 0;
          int e = arr[i].length-1;
        while(s<=e){
            if(s==e){
                arr[i][s] = arr[i][s]^1;
            }
           else{
             int temp = arr[i][s]^1;
             arr[i][s] = arr[i][e]^1;
             arr[i][e] = temp;

           
        }
         s = s + 1;
         e = e - 1;
        }
    }
    for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    
    return arr;
    
   }

}


import java.util.Arrays;

  public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        System.out.println("Before sorting:"+ Arrays.toString(arr));
     
        arr = bubblesort(arr);
        System.out.println("After sorting:"+ Arrays.toString(arr));
       
        
    }
    static int[] bubblesort(int[] arr){
       

        for (int i = 0; i < arr.length; i++) {
            
            for(int j=1;j < arr.length - i; j++){
                //swap if the element is greater than the next element
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
               

            }
        }
        return arr;
    }
}


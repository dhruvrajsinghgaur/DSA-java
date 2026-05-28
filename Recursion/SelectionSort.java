
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5};
      
       sort(arr, arr.length-1);
       System.out.println(Arrays.toString(arr));
       sort(arr, arr.length, 0, 0);
       System.out.println(Arrays.toString(arr));
    }
    // Method 1
    static void sort(int[] arr,int lastIndex){
      int maxindex = getmaxindex(arr, 0,lastIndex, 0);
      if(lastIndex<=0){
        return;
      }
      if(arr[lastIndex]<arr[maxindex]){
        swap(arr,lastIndex,maxindex);

      }
      sort(arr, lastIndex-1);
    }
    static int getmaxindex(int[] arr,int i,int lastIndex,int maxIndex){
      
        if(i>lastIndex){
            return maxIndex;
        }
        if(arr[i]>=arr[maxIndex]){
            maxIndex = i;

        }
        return getmaxindex(arr, i+1,lastIndex, maxIndex);
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Method 2
    static void sort(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[max]){
                 sort(arr, r, c+1, c);
            }
            else{
                 sort(arr, r, c+1, max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            sort(arr, r-1, 0, 0);
        }
    }
}

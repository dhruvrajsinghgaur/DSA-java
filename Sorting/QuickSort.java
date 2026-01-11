
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
         int[] arr = {1, 2, 6, 5, 4};
         //sort(arr, 0, arr.length-1);
         Arrays.sort(arr);
         System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s+(e-s)/2;
        while(s<=e){
            while(arr[s]<arr[m]){
                s++;
            }
            while(arr[e]>arr[m]){
                e--;
            }
            if(s<=e){
                swap(arr, s, e);
                s++;
                e--;
            }
        }
        sort(arr, low, e);
        sort(arr, s, high);

    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

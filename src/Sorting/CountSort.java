package Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2, 5, 2, 8};
        countsortHash(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void countsort(int[] arr){
        int largestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) largestElement = arr[i];
        }
        int[] freqArr = new int[largestElement + 1];
        for (int i = 0; i < arr.length; i++) {
            freqArr[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] != 0) {
                for (int j = 0; j < freqArr[i]; j++) {
                    arr[index] = i;
                    index++;
                }
            }
        }
    }
    
    // this method uses an hashmap to implement count sort.
    public static void countsortHash(int[] arr){
        int largestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) largestElement = arr[i];
        }
        HashMap<Integer, Integer> freqHash = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freqHash.put(arr[i], freqHash.getOrDefault(arr[i], 0) + 1);
        }
        int index = 0;
        for (int i = 0; i <= largestElement; i++) {
            int freq = freqHash.getOrDefault(i, 0);
            for (int j = 0; j < freq; j++) {
                arr[index] = i;
                index++;
            }
        }
        // this is also correct just written like above countsort function.
//        for (int i = 0; i <= largestElement; i++) {
//            if (freqHash.getOrDefault(i, 0) != 0) {
//                for (int j = 0; j < freqHash.get(i); j++) {
//                    arr[index] = i;
//                    index++;
//                }
//            }
//        }

    }
}

package Sorting;

import java.util.Arrays;
import java.util.Random;

public class RedixSort {
    public static void main (String[] args){
        int[] arr = {29, 83, 471, 36, 91, 8};
        int[] arr1 = {121, 21, 11};
        int[] arr3 = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] arr4 = {121, 111, 21, 11};
        int[] arr5 = {3,-1};

        redixsort(arr5);
        System.out.println(Arrays.toString(arr5));
    }

//    public static void main(String[] args){
//        int n = 100000; // 100k elements
//        int[] arr = new int[n];
//        Random rand = new Random();
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = rand.nextInt(1000000); // values from 0 to 999999
//        }
//
//        long start = System.currentTimeMillis();
//        RedixSort.redixsort(arr); // your current class
//        long end = System.currentTimeMillis();
//
//        System.out.println("First 100 elements sorted:");
//        System.out.println(Arrays.toString(Arrays.copyOf(arr, 100)));
//        //System.out.println(Arrays.toString(arr));
//        System.out.println("Time taken: " + (end - start) + " ms");
//    }
    public static void redixsort(int[] arr){
        int smallestElement = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallestElement) smallestElement = arr[i];
        }
        if (smallestElement < 0) {
            smallestElement = smallestElement * -1;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + smallestElement;
            }
            smallestElement = smallestElement * -1;
        }
        int largestElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largestElement) largestElement = arr[i];
        }
        int largestDigit = 0;
       while(largestElement != 0){
           largestElement = largestElement / 10;
           largestDigit++;
       }
       // we have to run count sort largestDigits times.
        for (int i = 0; i < largestDigit; i++) {
            countsort1(arr, i);
        }
        if (smallestElement < 0) {
            smallestElement = smallestElement * -1;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - smallestElement;
            }
        }
    }
    // this count sort method uses my logic but uses nested loop which makes it a little less optimized.
    // (this also changes a little bit of redix sort algo).
    public static void countsort(int[] arr, int place){
        int[] output = new int[arr.length];
        int[] freqArr = new int[10];
        int exp = (int) Math.pow(10, place);
        for (int i = 0; i < arr.length; i++) {
            freqArr[(arr[i] / exp) % 10]++;
        }
        int index = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] != 0) {
                int k = 0;
                for (int j = 0; j < freqArr[i]; j++) {
                    for (int l = k; l < arr.length; l++) {
                        if ((arr[l] / exp) % 10 == i){
                            output[index] = arr[l];
                            index++;
                            k = l + 1;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    // this count sort uses standard logic for count sort originally used in redix sort.
    public static void countsort1(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] freqArr = new int[10];
        int exp = (int) Math.pow(10, place);

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            freqArr[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            freqArr[i] = freqArr[i] + freqArr[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[freqArr[digit] - 1] = arr[i];
            freqArr[digit]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}

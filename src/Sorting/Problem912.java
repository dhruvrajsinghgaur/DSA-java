package Sorting;

public class Problem912 {
    public int[] sortArray(int[] arr) {
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
            countsort(arr, i);
        }
        if (smallestElement < 0) {
            smallestElement = smallestElement * -1;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - smallestElement;
            }
        }
        return arr;
    }
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
}

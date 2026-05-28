

public class Selection {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] empty = {};
        System.out.println("Before sorting: " + java.util.Arrays.toString(arr));   
        insertionsort(arr);
        System.out.println("After sorting: " + java.util.Arrays.toString(arr));
    }
    static void insertionsort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }
    static int[] selectionsort(int[] arr){
        for(int i = 0; i< arr.length; i++){
            int lastIndex = arr.length - i - 1;
            int maxindex = getmax(arr, 0, lastIndex + 1);
            swap(arr, maxindex, lastIndex);
        }

        return arr;
    }
    static int getmax(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int[] insertionnsertionsort(int[] arr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


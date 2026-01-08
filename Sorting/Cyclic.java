
public class Cyclic {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        System.out.println("Before sorting: " + java.util.Arrays.toString(arr));
        cyclicsort(arr);
        System.out.println("After sorting: " + java.util.Arrays.toString(arr));
        
    }
    static void cyclicsort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr,i,correctIndex);
            }
            else{
                i++;
            }
        }
        
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

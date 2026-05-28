
public class Missingelement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6}; // Example array with a missing element
        System.out.println(findmissing(arr));
    }
    
    static int findmissing(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i];
            if (arr[i]<arr.length && arr[i] != arr[correctIndex]) {
                swap(arr,i,correctIndex);
            }
            else{       
                i++;
            }
        }
        for(int index = 0; index< arr.length;index++){
          if(arr[index] != index){
            return index;
          }
        }
        return arr.length; // return length
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

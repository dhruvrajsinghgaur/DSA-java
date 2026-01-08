

import java.util.ArrayList;
import java.util.List;

//this code returns an array with the missing element
//if no element is missing, it returns an empty array
public class Missingarray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 3}; // Example array with a missing element
       
        System.out.println(findmissing(arr));
       
        
    }
    static List<Integer> findmissing(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr,i,correctIndex);
            }
            else{       
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>() ;
            
        
        for(int index = 0; index< arr.length;index++){
          if(arr[index] != index+1){
            ans.add(arr[index]); // add the missing element
           
            
          }
        }
        return ans; // return length
        
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}


import java.util.ArrayList;
import java.util.List;



public class SubSets {
   public static void main(String[] args) {
       int[] arr = {1, 2, 2};
       System.out.println(subsetduplicate(arr));
   }
   static List<List<Integer>> subset(int[] arr){
     List<List<Integer>> outer = new ArrayList<>();
     outer.add(new ArrayList<>());

     for (int nums : arr){
        int n = outer.size();
        for (int i = 0; i < n; i++) { 
        List<Integer> internal = new ArrayList<>(outer.get(i));
        internal.add(nums);
        outer.add(internal); 

        }
     }
     return outer;
   }
    // this method is used when there are duplicate element in the array so in the answer there are some repeations to avoid that repeatation this metod is used
     static List<List<Integer>> subsetduplicate(int[] arr){
     List<List<Integer>> outer = new ArrayList<>();
     outer.add(new ArrayList<>());
     int start = 0;
     int end = 0;

     for (int i = 0; i < arr.length ; i++){
        start = 0;
      
        // if current element is same as previous, only add it to the subsets
        // formed in the previous step to avoid duplicates
        if(i>0 && arr[i] == arr[i-1]){
            start = end+1;
        }
        end = outer.size()-1;
        int n = outer.size();
        for (int j = start; j < n; j++) { 
        List<Integer> internal = new ArrayList<>(outer.get(j));
        internal.add(arr[i]);
        outer.add(internal);
        }
     }
     return outer;
   }
}

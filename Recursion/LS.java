
import java.util.ArrayList;

public class LS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5};
        int target = 5;
        int i = 0;
       
       // System.out.println(lsforall(arr, target, i, new ArrayList<>()));
       System.out.println(lsforall1(arr, target, i));

        
    }
    static int ls(int[] arr, int target, int i){
        if(i == arr.length){
            return -1;
        }
        if (arr[i] == target)  return i;
        
        return ls(arr, target, i+1);
    }
    static boolean ls1(int[] arr, int target, int i){
         if(i == arr.length){
            return false;
        }
        return arr[i] == target || ls1(arr, target, i+1);
    }
       // this method is used to return an arraylist
    static ArrayList<Integer> lsforall(int[] arr, int target, int i , ArrayList<Integer> list){
        if(i == arr.length){
            return list;
        }
        if (arr[i] == target) {
             list.add(i);
            }
        
        return lsforall(arr, target, i+1, list);
    }
    
    // its process is important 
    // this method is not very optimized because its creating object again and again use the previous one and only use this when asked specifically
     static ArrayList<Integer> lsforall1(int[] arr, int target, int i){

        ArrayList<Integer> list = new ArrayList<>();

        if(i == arr.length){
            return list;
        }
        if (arr[i] == target) {
             list.add(i);
            }
        ArrayList<Integer> ansfrombelowfncalls = lsforall1(arr, target, i+1);

        list.addAll(ansfrombelowfncalls); 

        return list;
    }
}

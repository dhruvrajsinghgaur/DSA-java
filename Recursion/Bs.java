
public class Bs {

   public static void main(String[] var0) {
      int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
      byte target = 8;
      System.out.println(search(arr, target, 0, arr.length - 1));
   }

   static int search(int[] arr, int target, int s, int e) {
      if (s > e) {
         return -1;
      }
      int m = s + (e - s) / 2;
       if (arr[m] == target) {
            return m;
         } 
       if (arr[m] > target){
        return search(arr, target, 0, m - 1);
       }

      
       return search(arr, target, s + 1, e);
     
         
      }
    }
   

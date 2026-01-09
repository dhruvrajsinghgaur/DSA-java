import java.util.ArrayList;

public class Factors {
    
   public static void main(String[] args) {
    factor2(20);
   }
   // this is the most basic method and also less optimized

   static void factor(int n){
    for (int i = 1; i <= n; i++) {
        if (n%i==0) {
            System.out.print(i+" ");
        }
    }
   }

   // this method is optimized but does not return sorted elements 

   static void factor1(int n){
    
         for (int i = 1; i < Math.sqrt(n); i++) {
        if (n%i==0) {
             if(n/i==i) {
                System.out.print(i+" ");
             }
            else {
               System.out.print(i+" "+n/i+" ");
                   
                }
           
        }
    }
   }

// this method is same as factor1 just returns sorted elements 

   static void factor2(int n){
        ArrayList<Integer> list = new ArrayList<>();
         for (int i = 1; i < Math.sqrt(n); i++) {
        if (n%i==0) {
            if(n/i==i) {
                System.out.print(i+" ");
             }
            else {
                System.out.print(i+" ") ;
                   list.add(n/i);
                }
        }
    }
    for (int i = list.size() - 1; i >= 0; i--) {
        System.out.print(list.get(i)+" ");
    }
   }
}

public class SquareRoot {
    public static void main(String[] args) {
    System.out.println(squarroot(20, 4));
    // System.out.println(newtonsqrt(40));
   }
   static double squarroot(int n, int p){
    
     int s = 0;
     int e = n;
     double root = 0.0;

    while(s<=e){
       
        int m = s +(e - s)/2;
        if(m*m == n){
            
            return m;
           
        }
        if(m*m > n){

           e = e - 1;
        }
        if(m*m < n){
          root = m;
          s = s + 1;
            
        }
    }
    double incr = 0.1;
    for (int i = 0; i < p; i++) {
        while(root * root < n){
            root = root + incr;
        }
        root = root - incr;
        incr = incr/10;
    }
    
    return root;
   }

   static double newtonsqrt(int n){
    double x = n;
    double root ;
    while (true) { 
         root = 0.5*(x + (n/x));
         if(Math.abs(root -x) < 0.5) {
            break;
           }
        x = root;

    }
      return root;
   }
}

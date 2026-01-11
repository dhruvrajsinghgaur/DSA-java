public class Fibonacci {
      public static void main(String[] args) {
     System.out.println(fiboformula(6));

    }
      static int fiboformula(int n){
        

        return (int) (((Math.pow(((1+Math.sqrt(5))/2), n))-(Math.pow(((1-Math.sqrt(5))/2), n)))/Math.sqrt(5));
       
      }

      static int fibonacci(int n){

       // return n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);  same code using ternary operator.

        if(n<2){
          return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
      }

      static int fibo(int n){
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
          c = a + b;
          a = b;
          b = c;
        }
        return c;
      }
}

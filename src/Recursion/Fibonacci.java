package Recursion;
public class Fibonacci {
      public static void main(String[] args) {
     System.out.println(fiboformula(999));

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


    public int fibo(int n){
      int[] dp = new int[n + 1];

      dp[0] = 0;
      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
    }

    public int fibo1(int n){
      int dp0 = 0;
      int dp1 = 1;
      int dpn = 0;
      for (int i = 2; i <= n; i++) {
        dpn = dp1 + dp0;
        dp0 = dp1;
        dp1 = dpn;
      }
      return dpn;
    }

}

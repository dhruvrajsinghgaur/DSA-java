public class PrimeNo {
    public static void main(String[] args) {

        System.out.println(isprime(36));

        int n = 100;
      for (int i = 0; i <= n; i++) {
        if(isprime(i)==true){
            System.out.println(i);
        }
      }
    }
    // Method 1
    static boolean isprime(int n){
        if(n<=1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
   
   // Method 2
    static void sieve(int n , boolean[] primes){
        for (int i = 2; i*i <= n; i++) {
            if(!primes[i]){
                for (int j = 2*i; j <= n; j+=i) {
                    primes[j] = true;
                }
            }
            
        }
        
         for (int i = 2; i <= n; i++) {
            if(!primes[i]){
                System.out.print(i+" ");
            }
         }
   }
}

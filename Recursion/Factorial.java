
import java.math.BigInteger;
public class Factorial {
    public static void main(String[] args) {
        BigInteger f1000 = facto(1000);
        System.out.println(f1000.toString().length());
    }
    static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    static BigInteger facto(int n){
        BigInteger facto = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            facto = facto.multiply(BigInteger.valueOf(i));
        }
        return facto;
    }
}
 
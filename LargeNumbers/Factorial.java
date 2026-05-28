import java.math.BigInteger;
public class Factorial {
    static BigInteger factorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
 
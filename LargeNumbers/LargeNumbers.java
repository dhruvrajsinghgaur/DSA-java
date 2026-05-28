import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
public class LargeNumbers {
    public static void main(String[] args) {
        BI();
        System.out.println();
        BD();
        System.out.println();

        Factorial fc = new Factorial();
        BigInteger fb = fc.factorial(5);
        System.out.println(fb);
        
    }
    static void BI(){
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(56);
        BigInteger B = BigInteger.valueOf(44);
        BigInteger C = new BigInteger("34");

        // converting BigInteger to int.
        int c = B.intValue();

        // constants
        BigInteger D = BigInteger.ONE;
        BigInteger E = BigInteger.TWO;
        BigInteger F = BigInteger.TEN;
        BigInteger G = BigInteger.ZERO;

        // addition
        // we can not do A + B because A and B are objects.
        BigInteger s = A.add(B);

        // multiply
        BigInteger m = A.multiply(B);

        //divide
        BigInteger d = A.divide(B);

        // substraction
        BigInteger sub = A.subtract(B);

        // remainder
        BigInteger rem = A.remainder(B);

        System.out.println(C);
        System.out.println(c);
        System.out.println(s);
        System.out.println(m);
        System.out.println(d);
        System.out.println(sub);
        System.out.println(rem);

        
    }

    static void BD() {
        double a = 1.24;
        double b = 2.34;

        BigDecimal A = BigDecimal.valueOf(1.24);
        BigDecimal B = BigDecimal.valueOf(2.34);
        BigDecimal C = new BigDecimal("4.45");

        // converting BigDecimal to double.
        double c = B.doubleValue();

        // constants
        BigDecimal D = BigDecimal.ONE;
        BigDecimal E = BigDecimal.TWO;
        BigDecimal F = BigDecimal.TEN;
        BigDecimal G = BigDecimal.ZERO;

        // addition
        // we can not do A + B because A and B are objects.
        BigDecimal s = A.add(B);

        // multiply
        BigDecimal m = A.multiply(B);

        //divide
        // BigDecimal d = A.divide(B); (this shows arithmetic exception when the result is repeating decimals for eg 1/3). 
        BigDecimal d = A.divide(B, 10, RoundingMode.HALF_UP); // scale = 10 digits


        // substraction
        BigDecimal sub = A.subtract(B);

        // remainder
        BigDecimal rem = A.remainder(B);

        System.out.println(C);
        System.out.println(c);
        System.out.println(s);
        System.out.println(m);
        System.out.println(d);
        System.out.println(sub);
        System.out.println(rem);

      
    }
}

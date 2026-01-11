public class DigitSum {
     public static void main(String[] args) {
        System.out.println(digitsum(1342));
        System.out.println(digitproduct(1342));
     }
     static int digitsum(int n){
        if( n == 0 ) return 0;

        return (n%10)+digitsum(n/10);
     }
     static int digitproduct(int n){
         if( n == 0 ) return 1;

        return (n%10)*digitproduct(n/10);
     }
}

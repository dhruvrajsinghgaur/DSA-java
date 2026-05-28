public class ReverseDigits {
    public static void main(String[] args) {
       System.out.println( rev2(12345));
       System.out.println(palindrome(1));
    }
    // method 1 this method prints the value only and do not return it
    static void rev(int n){
        if( n == 0 ) return;
        System.out.print(n%10);
        rev(n/10);
    }

    //this method uses an extra variable outside means does not solve it with pure recursion
    static int sum = 0;
    static void rev1(int n){
        if( n == 0){
            return;
        }
        int rem = n%10;
        sum = sum*10+rem;
        rev1(n/10);

    }
    // this method uses an helper function
    static int rev2(int n){
        int digits = (int) Math.log10(n)+1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits){
    
        if (n < 10){
            return n;
        }
        return (int) ((n%10)*Math.pow(10, digits-1) + helper(n/10,digits-1));
    }

    // palindrome program using helper function
    static boolean palindrome(int n){
        if (rev2(n) == n) return true;

        return false;
    }

}

package DSAMath;

public class LC_50 {

    // Method 1
    // TC: O(logN)
    public double power(double x, int n){
        if (n == 0) return 1;

        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        double pow = 1;

        while(n != 0){
            if ((n & 1) != 0) {
                pow *= x;
            }
            x = x*x;
            n = n/2;
        }

        return pow;
    }

    // Method 2.
    // TC: O(n)
    // Gives TLE on leetCode
    public double power1(double x, int n){
        if (n == 0) return 1;

        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        double pow = 1;

        for (int i = 0; i < n; i++) {
            pow = pow * x;
        }

        return pow;
    }

    void main(){
        double x = 2;
        int n = 10;

        System.out.println(power1(x, n));
    }
}

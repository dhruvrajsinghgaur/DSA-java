

public class XorOfAToB {
    public static void main(String[] args) {
        xorofatob(3, 9);
    }
   
    static void xorofatob(int a,int b){
        int ans = xor0toa1(b)^xor0toa1(a-1);
        System.out.println("the xor of nunms "+a+" to "+b+" is equal to "+ ans);
    }
     static int xor0toa1(int a){
     if (a % 4 == 0) return a;
    if (a % 4 == 1) return 1;
    if (a % 4 == 2) return a + 1;
    if (a % 4 == 3) return 0;

    return 0;
     }
     
     // this method will give TLE(Time Limit Exceed)for large number
     static void xorofatob1(int a,int b){
        int ans = 0;
        for(int i = a; i <= b; i++){
            ans = ans^i;
        }
        System.out.println("the xor of nunms "+a+" to "+b+" is equal to "+ ans);
    }
}

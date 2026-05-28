
public class XorOf0ToA {
    public static void main(String[] args) {
        
       System.out.println(xor0toa(6));
        
    }
    
    static int xor0toa(int a){
     if (a % 4 == 0) return a;
    if (a % 4 == 1) return 1;
    if (a % 4 == 2) return a + 1;
    if (a % 4 == 3) return 0;

    return 0;
    }

    // this method will give TLE(Time Limit Exceed) for large number
    static void xor0toa1(int a){
        int ans = 0;
        for(int i = 0; i <= a; i++){
            ans = ans^i;
        }
        System.out.println("the xor of nums 0 to a is "+ ans);
    }
}

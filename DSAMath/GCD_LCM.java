
public class GCD_LCM{
   public static void main(String[] args) {
     System.out.println(gcd(2, 4));
     System.out.println(lcm(2, 4));
   }
   static int gcd(int a , int b){
    if(a==0){
        return b;
    }
    return gcd(b%a, a);
   }
   static int lcm(int a , int b){
    int lcm = (a*b)/gcd(a, b);
    return lcm;
   }
 }


 



public class NumberOfSetBits {
    public static void main(String[] args) {
      
       setbits1(6);

   
    }
    static void setbits(int n){
        System.out.println(Integer.toBinaryString(n)); // no need just to check 
             int count = 0;
        while(n>0){
         if ((n&1)==1){
            count++;
        }
        n = n>>1;
        }
        System.out.println("number of set bits are: "+ count);
    }
    static void setbits1(int n){
        System.out.println(Integer.toBinaryString(n)); // no need just to check 
        int count = 0;
        while(n>0){
        count++;
        n = n-(n&-n);  // can be wriitten as n -= (n&-n)
       //n = n&(n-1); // also correct logic
        }
       System.out.println("number of set bits are: "+ count);
    }
}

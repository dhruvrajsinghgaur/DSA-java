public class MagicNumber{
     public static void main(String[] args) {
       magicnumber(6);
    }
    static void magicnumber(int n){
      int ans=0;
      int base = 5;
      int count=0;
    while (n>0) {
      int last = n&1;
      n=n>>1;
      count++;
      ans += last*base;
      base = base*5; 
        
    }
    System.out.println(ans);
    System.out.println(count);  //gives how much time will loop run
    }
}


// important asked in amazon.
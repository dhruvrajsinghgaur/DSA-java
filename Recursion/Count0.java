
public class Count0 {
    public static void main(String[] args) {
        int count = counter(30204);
       
      System.out.println(count);

    }
    static int counter(int n){
      return helper(n, 0);
    }
    // this also shows how to pass value to above calls
    private static int helper(int n,int count){
       if(n<=0){
        return count;
       }
        int rem = n%10;
        if(rem == 0){
           return helper(n/10,count+1);  // or we can also do count++
        }
        return helper(n/10,count);
    }
}

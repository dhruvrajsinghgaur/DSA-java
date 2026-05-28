

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 0;
        boolean ans;
        if(n==0){
            ans = false;
        }
        else{
        ans = (n&(n-1))==0;
        }
        System.out.println(ans);
    }
}

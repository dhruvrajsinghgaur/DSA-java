
import java.util.*;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[m];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }
            System.out.println(game(a, b, x));
        }
        // int[] arr1 = {4,2,4,6,1};
        // int[] arr2 = {1,2,8,5};
        // int maxsum = 10;

        // int a = game(arr2, arr2, maxsum);
        // System.out.println(a);

    }
    static int game(int[] a, int[] b, int maxsum){
        return helper(maxsum, a, b, 0, 0) - 1;
    }
   static int helper(int maxsum, int[] a, int[] b, int sum, int count){

    if (sum > maxsum) return count;

    if (a.length == 0 || b.length == 0) return count;
 
    int ans1 = helper(maxsum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
   
    int ans2 = helper(maxsum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

   return Math.max(ans1, ans2);

    }
}

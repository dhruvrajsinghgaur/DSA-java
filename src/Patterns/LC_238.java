package Patterns;

public class LC_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        p[0] = 1;
        for(int i = 1; i < n; i++){
            p[i] = p[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            p[i] = p[i] * suffix;
            suffix = suffix * nums[i];
        }
        return p;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;

        int[] p = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++){
            p[i] = prefix[i] * suffix[i];
        }

        return p;
    }
}

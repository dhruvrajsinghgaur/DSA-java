package SquareRootDecomposition;

import java.util.Arrays;

// it is also known as MO's algorithm.
public class SQRTDecomposition {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        int sqrt = (int) Math.sqrt(n);
        //System.out.println(sqrt);
        int block_id = -1;
        int[] blocks = new int[sqrt + 1];
        for(int i = 0; i < n; i++){
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] = blocks[block_id] + arr[i];
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(blocks));
//        update(blocks, arr,1 ,1, sqrt);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(blocks));
        int ans = query(arr, blocks,2 ,7, sqrt);
        System.out.println(ans);
    }

    // for this we are doing sum query.
    public static int query(int[] arr, int[] blocks, int left, int right, int sqrt){
        int ans = 0;
        // for left
        while(left % sqrt != 0 && left <= right){
            ans = ans + arr[left];
            left++;
        }
        // for middle
        while(left + sqrt <= right){
            ans = ans + blocks[left / sqrt];
            left = left + sqrt;
        }
        // for right
        while(left <= right){
            ans = ans + arr[left];
            left++;
        }
        return ans;
    }

    public static void update(int[] blocks, int[] arr, int i, int val, int sqrt) {
        int block_id = i / sqrt;
        blocks[block_id] = blocks[block_id] + (val - arr[i]);
        arr[i] = val;
    }
}

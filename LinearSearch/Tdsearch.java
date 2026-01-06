
import java.util.Arrays;


public class Tdsearch {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        int target = 9; // Element to search for
        int[] result = search2d(matrix, target);
        System.out.println(Arrays.toString(result));

    }
    static int[] search2d( int[][] mat,int target){
        if(mat == null || mat.length == 0){
            return new int[]{-1,-1}; // Array is empty or null
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == target){
                    return new int[]{i,j}; // Element found at index (i, j)
                }
                }
            }
       return new int[]{-1,-1}; // Element not found}

    }}


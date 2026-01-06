
public class Search2d {
    public static void main(String[] args){
        int [][] matrix ={{1,2,3},
                          {4,5},
                          {6,7,8,9}};
        int target = 5; // Element to search for
        // Example 2D array
       int result =search2d(matrix, target);
        if(result == -1){
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index (i, j) with sum of indices: " + result);

        }
    }
        static int search2d(int [][] matrix, int target){
            if(matrix == null || matrix.length == 0){
                return -1; // Array is empty or null
            }
            for(int i=0; i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if (matrix[i][j] == target){
                        return i+j; // Element found at index (i, j)
                    }
                }
            }
            return -1; // Element not found
    }
}
   
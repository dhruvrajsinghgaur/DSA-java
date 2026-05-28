import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem101 {

    // Method 1.
    // works but has very bad complexity.
    public boolean isSymmetric1(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
    if (root == null) return true;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        boolean hasNonNull = false; // tracks if next level has real nodes

        for (int i = 0; i < levelSize; i++) {
            TreeNode currentNode = queue.poll();

            if (currentNode == null) {
                currentLevel.add(null);
                // don’t expand further if null — just placeholders
                queue.add(null);
                queue.add(null);
            } else {
                currentLevel.add(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);

                if (currentNode.left != null || currentNode.right != null) {
                    hasNonNull = true;
                }
            }
        }
        result.add(currentLevel);

        // stop when next level has no non-null nodes
        if (!hasNonNull) break;
    }
        boolean ans = true;
        for (int i = 0; i < result.size(); i++) {
            int j = 0;
            int k = result.get(i).size() - 1;
            while(j<=k){
                if (result.get(i).get(j) == result.get(i).get(k)){
                    j++;
                    k--;
                }
                else{
                    return false;
                }
            }
        }
     return ans;
    }

    // Method 2.
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            
                
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if (left == null && right == null) continue;
                if (left == null || right == null) return false;
                if (left.val != right.val) return false;
                
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
        }
        return true;
    }
}
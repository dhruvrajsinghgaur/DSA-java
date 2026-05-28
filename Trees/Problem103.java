import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
       
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);  
            }
            if (level%2==0) currentlevel = currentlevel.reversed();
            result.add(currentlevel);
            level++;
        }
     return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

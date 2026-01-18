import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        if ((level1(root, x) == level1(root, y)) || !siblings(root, x, y)) return true;
        return false;
    }

    public boolean siblings(TreeNode root, int x, int y) {
        if (root == null || root.left == null || root.right == null) return false;
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y) return true;
            if (root.left.val == y && root.right.val == x) return true;
        }
        return siblings(root.left, x, y) || siblings(root.right, x, y);
    }
    // Method 1 for finding level.
    // more complex, high in time and space complexity and level can be find in less complexity like in method 2.
    public int level1(TreeNode root, int x) {
        List<List<Integer>> result = new ArrayList<>();
       
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentlevel);
        }
        int level = 0;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                if (result.get(i).get(j) == x) level = i;
            }
        }
     return level;
    }

    // Method 2 for finding level.
    // less complex.
    public int level2(TreeNode root, int x, int level) {
        if (root == null) return -1;
        if (root.val == x) return level;
        int left = level2(root.left, x, level+1);
        if (left != -1) return left;
        int right = level2(root.right, x, level+1);
        if (right != -1) return right;
        return -1;
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
package Trees;
public class Problem129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int pathval){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return pathval*10 + root.val;
        return helper(root.left, pathval*10 + root.val) + helper(root.right, pathval*10 + root.val);
    }
}

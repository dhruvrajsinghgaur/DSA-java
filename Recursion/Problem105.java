import java.util.Arrays;
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, inorder);
    }
    TreeNode root = new TreeNode();
    int n = 0;
    private TreeNode helper(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return root;
        // finding the index of root node in inorder.
        int rootindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) rootindex = i;
        }
        
        root.val = rootindex;
        
        TreeNode left = helper(Arrays.copyOfRange(preorder, n++, rootindex - 1), Arrays.copyOfRange(inorder, 0, rootindex - 1));
        TreeNode right = helper(Arrays.copyOfRange(preorder, n+2, rootindex - 1), Arrays.copyOfRange(inorder, rootindex + 1, inorder.length));

        
        return root;

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

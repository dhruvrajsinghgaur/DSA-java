package Trees;
public class Problem124 {
    int maxsum = 0;
    public int maxPathsum(TreeNode root){
        helper(root);
        return maxsum;
    }
    public int helper(TreeNode root) {
       if (root == null) return 0;
        int leftpath = helper(root.left);
        int rightpath = helper(root.right);
        leftpath = Math.max(0,leftpath);
        rightpath = Math.max(0,rightpath);
        int currentpathval = root.val + leftpath + rightpath;
        maxsum = Math.max(maxsum,currentpathval);
        return Math.max(leftpath,rightpath) + root.val;
    }
}

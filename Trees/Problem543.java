public class Problem543 {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root){
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        int dia = left + right;
        diameter = Math.max(diameter, dia);

        return Math.max(left, right) + 1;
    }
}
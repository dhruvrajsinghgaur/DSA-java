package Trees;

public class LC_99 {
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    void inorder(TreeNode node){
        if (node == null) return;

        inorder(node.left);

        TreeNode curr = node;

        if (prev != null && prev.val > curr.val){
            if (first == null) first = prev;
            second = curr;
        }

        prev = curr;

        inorder(node.right);
    }
}

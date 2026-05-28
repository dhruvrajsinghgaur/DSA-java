import java.util.ArrayList;
import java.util.List;

public class Problem98 {

    // Method 1.
    // uses an extra list.
     public boolean isValidBST1(TreeNode root) {
         List<Integer> list = new ArrayList<>();
      
         List<Integer> ans = inorder(root, list);
       
         return issorted(ans);
    }
    private boolean issorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
     private List<Integer> inorder(TreeNode node, List<Integer> list){
        if (node == null) return list;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        return list;
    }

    // Method 2.
    // no extra list used.
   public boolean isValidBST(TreeNode root){

        return isValidBST(root, null, null);
    }
    private boolean isValidBST(TreeNode root, Integer low, Integer high) {

        if (root == null) return true;

        if (root.val >= high || root.val <= low) return false;

        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Problem114 {

    // Method 1.
    // uses extra space (o(n) space complexity).
    public void flatten(TreeNode root) {
    if (root == null) return;
    List<Integer> list = new ArrayList<>();
    list = preorder(root, list);

    TreeNode current = root;
    current.left = null;

    for (int i = 1; i < list.size(); i++) {
        current.right = new TreeNode(list.get(i));
        current = current.right;
    }

    }
    private List<Integer> preorder(TreeNode node, List<Integer> list){
        if (node == null) return list;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
        return list;
    }

    // Method 2.
    // uses no extra space (o(1) space complexity).
    public void flatten1(TreeNode root){
        if (root == null) return;
       TreeNode current = root;

       while(current != null){
        if (current.left != null){
            TreeNode temp = current.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = current.right;
            current.right = current.left;
            current.left = null;
        }
        current = current.right;
       }
   
    }
}

    

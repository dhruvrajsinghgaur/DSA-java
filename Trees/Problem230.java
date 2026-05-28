import java.util.ArrayList;
import java.util.List;

public class Problem230 {


    // Method 1.
    // time and space complexity both o(n).
    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = inorder(root, list);

        return ans.get(k-1);
    }
    private List<Integer> inorder(TreeNode node, List<Integer> list){
        if (node == null) return list;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
        return list;
    }

    // Method 2.
    // time complexity o(h + k). (stops when Kth smallest element is found)
    // space complexity o(h). (for recursive stack only)
    // h is height of tree.
    
    int count = 0;
    int result = 0;
    public int kthSmallest2(TreeNode root, int k){
       helper(root, k);
       return result;
    }

    private void helper(TreeNode root, int k){
        if (root == null) return;
        
        helper(root.left, k);
        count++;
       if (count == k) { 
           result = root.val;
           return;
       }
        helper(root.right, k); 
    }

   
}



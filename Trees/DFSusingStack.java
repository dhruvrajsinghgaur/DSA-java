// this is an iterartive approach.
package Trees;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class DFSusingStack {
    public List<Integer> dfs(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode currentnode = s.pop();
            ans.add(currentnode.val);
            if (currentnode.right != null) s.push(currentnode.right);
            if (currentnode.left != null) s.push(currentnode.left);
        }
        return ans;
    }
}

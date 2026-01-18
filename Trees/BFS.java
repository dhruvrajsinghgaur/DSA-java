import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    // also the solution of LC 102.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
       
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            result.add(currentlevel);
        }
     return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> result = levelOrder(root);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
           list.add(result.get(i).getLast());
        }
        return list;
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

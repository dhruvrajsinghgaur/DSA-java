import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem637 {

    // Method 1.
    // my method (it uses an extra for loop).
    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> result = new ArrayList<>();
       
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currentlevel = new ArrayList<>(levelsize);
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                currentlevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            Double avg = 0.0000;
            for (int i = 0; i < currentlevel.size(); i++) {
                avg = avg + currentlevel.get(i);
            }
            avg = (avg/currentlevel.size());
            result.add(avg);
        }
     return result;
    
    }

    // Method 2.
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
       
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            Double average = 0.0000;
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                average = average + currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            average = (average/levelsize);
            result.add(average);
        }
     return result;
    
    }

    // Method 1.
    public Integer nextelement1(TreeNode root, int value) {
        List<Integer> result = new ArrayList<>();
       
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                result.add(currentNode.val);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
     int ans = result.indexOf(value);
     if (ans == -1 || ans == result.size()-1) return null;
     else return result.get(ans + 1);
    }

    // Method 2.
    public Integer nextelement2(TreeNode root, int value) {
       
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.val == value) return (queue.peek() != null) ? queue.peek().val : null;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
     return null;
}

    public TreeNode nextelement3(TreeNode root, int value) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
            if (currentNode.val == value)  return queue.peek();
        }
     return null;
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
}
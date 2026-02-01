package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem297 {
     public String serialization(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if (root == null) return sb.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode currentnode = queue.poll();

            if (currentnode == null){
                sb.append("null,");
                continue;
            }
            sb.append(currentnode.val).append(",");
            queue.add(currentnode.left);
            queue.add(currentnode.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
    String[] str = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(str[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int i = 1;
    while(!queue.isEmpty() && i < str.length){
    TreeNode currentNode = queue.poll();
    
    if(!str[i].equals("null")){
        currentNode.left = new TreeNode(Integer.parseInt(str[i]));
        queue.add(currentNode.left);
    }
    i++;
    if(!str[i].equals("null") && i < str.length){
        currentNode.right = new TreeNode(Integer.parseInt(str[i]));
        queue.add(currentNode.right);
    }
    i++;
    root = currentNode;
    }
    return root;
    }
}


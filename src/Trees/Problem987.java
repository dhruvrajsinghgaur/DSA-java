package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

// these solutions are not valid for the question do this question again.
public class Problem987 {
    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int row = getDepth(root, 0, root);
        helper1(root, list, row, 0);
        for (List<Integer> r : list) r.removeIf(Objects::isNull);
        return list;
    }
    private void helper1(TreeNode root, List<List<Integer>> list, int rowindex, int colindex){
        if (root == null) return;
        while(list.size() <= rowindex) list.add(new ArrayList<>());
        while(list.get(rowindex).size() <= colindex) list.get(rowindex).add(null);
        list.get(rowindex).set(colindex, root.val);
        helper1(root.left, list, rowindex-1, colindex+1);
        helper1(root.right, list, rowindex+1, colindex+1);
    }
    private int getDepth(TreeNode node, int depth, TreeNode root){
        if (node == null) return 0;
        int value1 = getDepth(node.left, depth+1, root);
        int value2 = 0;
        if (node != root) value2 = getDepth(node.right, depth-1, root);
        int value = value1 > value2 ? value1 : value2;
        return depth < value ? value : depth;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        HashMap<TreeNode, Integer> rowmap = new HashMap<>();
        HashMap<TreeNode, Integer> colmap = new HashMap<>();
        int rowindex = getDepth(root, 0, root);
        helper(root, rowmap, colmap, rowindex, 0);
        return list;
    }
    private void helper(TreeNode root, HashMap<TreeNode, Integer> rowmap, HashMap<TreeNode, Integer> colmap, int rowindex, int colindex){
        if (root == null) return;
        rowmap.put(root, rowindex);
        colmap.put(root, colindex);
        helper(root.left, rowmap, colmap, rowindex-1, colindex);
        helper(root.right, rowmap, colmap, rowindex+1, colindex+1);
    }
}

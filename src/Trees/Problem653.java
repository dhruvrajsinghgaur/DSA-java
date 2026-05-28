package Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem653 {
    // Method 1.
    // TC : O(n).
    public boolean findTarget(TreeNode root, int k) {
       HashSet<Integer> set = new HashSet<>();
       return helper(root, k, set);
    }
    private boolean helper(TreeNode node, int k, HashSet<Integer> set){
        if(node == null) return false;
        if (set.contains(k - node.val)) return true;
        set.add(node.val);
        return helper(node.left, k, set) || helper(node.right, k, set);
    }

    // Method 2.
    // TC : O(n^2).
    public boolean findTarget1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return twoSum(list, k);
    }
    public boolean twoSum(List<Integer> list, int target) {
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if (i != j) {
                    if (list.get(i) + list.get(j) == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void preorder(TreeNode node, List<Integer> list){
        if (node == null) return;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}



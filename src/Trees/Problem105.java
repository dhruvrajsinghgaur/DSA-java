package Trees;

import java.util.Arrays;
import java.util.HashMap;
public class Problem105 {
    // Method 1.
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, inorder.length - 1, map);
    }
    private TreeNode helper(int[] preorder, int instart, int inend, HashMap<Integer, Integer> map) {
        if (instart > inend) return null;
        int rootVal = preorder[preIndex++];
        TreeNode node = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        node.left = helper(preorder, instart, rootIndex - 1, map);
        node.right = helper(preorder, rootIndex + 1, inend, map);
        return node;
    }
    // Method 2.
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // finding the index of root node in inorder.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper1(preorder, 0 , 0, inorder.length, map);
    }
    private TreeNode helper1(int[] preorder, int prestart, int instart, int inend, HashMap<Integer, Integer> map) {
        if  (prestart >= preorder.length || instart > inend) return null;
        int rootindex = map.get(preorder[prestart]);
        TreeNode node = new TreeNode(preorder[prestart]);
        int sizeleft = rootindex - instart;
        node.left = helper1(preorder, prestart+1, instart, rootindex-1, map);
        node.right = helper1(preorder, prestart + sizeleft + 1, rootindex+1, inend, map);
        return node;
    }
    // Method 3.
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // finding the index of root node in inorder.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int rootindex = map.get(preorder[0]);
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree2(Arrays.copyOfRange(preorder, 1, rootindex + 1), Arrays.copyOfRange(inorder, 0, rootindex));
        node.right = buildTree2(Arrays.copyOfRange(preorder, rootindex + 1, preorder.length), Arrays.copyOfRange(inorder, rootindex + 1, inorder.length));

        return node;
    }
    // Method 4.
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // finding the index of root node in inorder.
        int rootindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) rootindex = i;
        }
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree3(Arrays.copyOfRange(preorder, 1, rootindex + 1), Arrays.copyOfRange(inorder, 0, rootindex));
        node.right = buildTree3(Arrays.copyOfRange(preorder, rootindex + 1, preorder.length), Arrays.copyOfRange(inorder, rootindex + 1, inorder.length));
        return node;
    }
}
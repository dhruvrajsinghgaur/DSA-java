package Trees;

import java.util.ArrayList;
import java.util.List;
public class BSTtoDLL {
    // Method 1.
    // TC : O(n).
    // SC : O(h) (h is height of tree).
    // In this space complexity is less because there is no list in it.
    Node head = null;
    Node temp = head;
    public BSTtoDLL() {}
    public Node BstToDll(TreeNode root) {
        inorder(root);
        return head;
    }
    private void inorder(TreeNode root) {
        if  (root == null) return;
        inorder(root.left);
        Node curr = new Node(root.val);
        if (head == null) {
            head = curr;
            temp = head;
        }
        else {
            temp.next = curr;
            curr.prev = temp;
            temp = temp.next;
        }
        inorder(root.right);
    }

    // Method 2.
    // TC : O(n).
    // SC : O(n).
    public Node BstToDll2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Node head = new Node(list.get(0));
        Node temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp.next.prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

public class Node{
    int val;
    Node next;
    Node prev;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
}


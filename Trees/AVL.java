class AVL {

    
    public class Node {
    private int value;
    private int height;
    private Node left;
    private Node right;

    public Node (int value){
        this.value = value;
    }

    public int getvalue(){
        return value;
    }

    }

    private Node root;

    public AVL(){
    }

    public int height(){
        return height(root);
    }
    public int height (Node node){
        if (node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "ROOT NODE : ");
    }
    private void display(Node node, String details){
        if (node == null){
            return;
        }
        System.out.println(details + node.getvalue());

        display(node.left, "left child of " + node.getvalue() + " : ");
        display(node.right, "right child of " + node.getvalue() + " : ");
    }
    public void insert(int value){
       root = insert(value, root);
    }
    private Node insert(int value, Node node){
        if (node == null){
            return new Node(value);
        }
        
        if (value < node.value){
            node.left = insert(value, node.left);
        }
        if (value > node.value){
           node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void populatesorted(int[] nums){
        populatesorted(nums, 0, nums.length - 1);
    }
    private void populatesorted(int[] nums, int s, int e){
       if (s > e) {
           return;
       }
       int m = s + (e - s)/2;
       insert(nums[m]);
       populatesorted(nums, s, m);
       populatesorted(nums, m+1, e);
    }

    public boolean isbalanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if (node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if (node == null) return;
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(){
        inorder(root);
    }
    private void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public Node rotate (Node node){
        // left heavy.
        if (height(node.left) - height(node.right) > 1) {
            // left left case.
            if (height(node.left.left) - height(node.left.right) >= 0) {
                return rotateright(node);
            }
            // left right case.
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = rotateleft(node.left);
                return rotateright(node);
            }

        }
        
        // right heavy.
        if (height(node.left) - height(node.right) < -1) {
            // right right case.
            if (height(node.right.right) - height(node.right.left) >= 0) {
                return rotateleft(node);
            }
            // right left case.
            if (height(node.right.right) - height(node.right.left) < 0) {
                node.right = rotateright(node.right);
                return rotateleft(node);
            }
        }
        return node;
    }

    public Node rotateright(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public Node rotateleft(Node p){
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }
}

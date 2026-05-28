
class SegmentTree {
private class Node {
     int data;
     int start;
     int end;
     Node left;
     Node right;

    

    public Node(int start, int end){
        this.start = start;
        this.end = end;
    }

    }

    Node root;

    public SegmentTree(int[] arr){
        // create a tree using this array.
        this.root = ConstructTree(arr, 0, arr.length - 1);
    }

    private Node ConstructTree(int[] arr, int startindex, int endindex){
        // leaf node.
        if (startindex == endindex) {
            Node node = new Node(startindex, endindex);
            node.data = arr[startindex];
            return node;
        }
        // create a new node with index you are currently at.
        Node node = new Node(startindex, endindex);
        int mid = startindex + (endindex - startindex)/2;
        node.left = ConstructTree(arr, startindex, mid);
        node.right = ConstructTree(arr, mid + 1, endindex);

        node.data = node.left.data + node.right.data;

        return node;
        
    }

    public void display(){
        display(this.root);
    }

    // display
    private void display(Node node){
        String str = "";
        if (node.left != null) 
        str = str + "Interval = [" + node.left.start + "," + node.left.end + "]" + " and Data = " + node.left.data + " => " ;
        else
        str = str + "no left child => ";

        // for current node.
        str =  str + "Interval = [" + node.start + "," + node.end + "]" + " and Data = " + node.data + " ";

        if (node.right != null) 
        str = str + "<= Interval = [" + node.right.start + "," + node.right.end + "]" + " and Data = " + node.right.data;
        else
        str = str + "<= no right child";

        System.out.println(str);

        if (node.left != null) display(node.left);

        if (node.right != null) display(node.right);

    }
    
    // query
    public int query(int qsi, int qei){
        return query(root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei){
        if (node.start >= qsi && node.end <= qei) {
            // node is completely lying inside.
            return node.data;
        }
        else if (node.start > qei || node.end < qsi){
            // lying completely outside.
            return 0;
        }
        else{
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    // update the value at perticular index.
    public void update(int index, int value){
        this.root.data = update(root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.start && index <= node.end) {
            if (index == node.start && index == node.end) {
                node.data = value;
                return node.data;
            }
            else{
                int leftans = update(node.left, index, value);
                int rightans = update(node.right, index, value);
                node.data = leftans + rightans;
                return node.data;
            }
        }
        return node.data;
    }
}


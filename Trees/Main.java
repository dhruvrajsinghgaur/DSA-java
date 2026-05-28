
public class Main {

    // public static void main(String[] args) {
    //     int threads = Runtime.getRuntime().availableProcessors(); // all CPU cores
    //     System.out.println("Starting stress test on " + threads + " threads...");

    //     for (int i = 0; i < threads; i++) {
    //         new Thread(() -> {
    //             while (true) {
    //                 // Do some meaningless math to keep CPU busy
    //                 double x = Math.random() * Math.random();
    //             }
    //         }).start();
    //     }
    // }

   public static void main(String[] args) {
        // BinaryTree bt = new BinaryTree();
        // Scanner scanner = new Scanner(System.in);
        // bt.populate(scanner);
        // bt.prettydisplay();

        // BST bst = new BST();
        //int[] nums = {15,10,5,8,12,20};

        // bst.populate(nums);
        // bst.display();
        // bst.preorder();
        // System.out.println();
        // bst.inorder();
        // System.out.println();
        // bst.postorder();

        // AVL tree = new AVL();
        // for (int i = 0; i < 100000; i++) {
        //     tree.insert(i);
        // }
        // System.out.println(tree.height());

        // int[] arr = {3,8,7,6,-2,-8,4,9};
        // SegmentTree tree = new SegmentTree(arr);
        // tree.update(3, 14);
        // System.out.println(tree.query(2, 6));

        // tree.display();
   }

   static int[] two(int[] arr, int target){
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) return new int[] {i, j};
        }
    }
    return new int[] {-1, -1};
   }
}
    
  


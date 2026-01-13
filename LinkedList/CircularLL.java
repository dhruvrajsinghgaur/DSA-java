public class CircularLL {
    private Node head;
    private Node tail;

    private int size;

     
     public CircularLL(){
        this.head = null;
        this.tail = null;
     }

     public void insert(int val){
        Node node = new Node(val);

        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;

     }
     public void delete(int val){
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.val == val){
            head = head.next;
            tail.next = head;
            return;
        }

        do { 
            Node n = node.next;
            if (n.val == val){
                node.next = n.next;
                return;
            }
            node = node.next;
        } while(node != head);
     }
     public void display(){
        Node node = head;
        if(node != null){
            do { 
               System.out.print("[" + node.val + "]" + " -> ");
               node = node.next;
            } while (node != head);
        }
        System.out.println("HEAD");
     }


    private class Node{
     int val;
     Node next;

     public Node(int val){
        this.val = val;
     }

     public Node(int val,Node next){
        this.val = val;
        this.next = next;
     }
 }
 public static void main(String[] args) {
     CircularLL list = new CircularLL();

     list.insert(1);
     list.insert(2);
     list.insert(3);
     list.insert(4);
     
     list.display();
 }
}

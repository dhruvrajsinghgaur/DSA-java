
public class DoublyLL {
     Node head;
     Node tail;

     int size;

    public DoublyLL(){
        this.size = 0;
    }

    public void insertfirst(int val){
        Node node = new Node(val);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null){
            tail = node;
        }

        size++;
    }

    public void insertlast(int val){
        Node node = new Node(val);
         Node last = head;
         node.next = null;

        if (head == null) {
          head = node;
          return;
        }
         
        while(last.next != null){
           last = last.next;
        }
        last.next = node;
        node.next = null;
        node.prev = last;

    }
    // this method inserts at the given index
      public void insert(int val, int index){
        if (index == 0){
            insertfirst(val);
            return;
        }
        if (index == size){
            insertlast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next, temp.prev);
        temp.next = node;
        node.prev = temp;
        size++;
    }
    // this method inserts the element after the given element without index
     public void insert1(int after, int val){
        Node p = find(after);
       if (p == null){
        System.out.println("does not exist");
        return;
       }
       Node node = new Node(val);
       node.next = p.next;
       p.next = node;
       node.prev = p;
       if(node.next != null){
        node.next.prev = node;
       }
      
        size++;
    }

     public Node find(int value){
        Node node = head;
      while(node != null){
        if (node.val == value){
            return node;
        }
        node = node.next;
      }
        return null;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print("[" + temp.val + "]" + " <-> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public void displayreverse(){
           Node temp = tail;
        while(temp != null){
            System.out.print("[" + temp.val + "]" + " <-> ");
            temp = temp.prev;
        }
        System.out.println("start");
    }
    // without using tail
     public void displayreverse1(){
           Node temp = head;
           Node last = null;
        while(temp != null){
            last = temp;
            temp = temp.next;
        }

        while(last != null){
            System.out.print("[" + last.val + "]" + " <-> ");
            last = last.prev;
        }
        System.out.println("start");
    }

  private class Node{
     int val;
     Node next;
     Node prev;

    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

   }
   public static void main(String[] args) {

    DoublyLL list = new DoublyLL();

    list.insertfirst(2);
    list.insertfirst(8);
    list.insertfirst(3);
    list.insertfirst(9);

    list.insertlast(5);
    list.insert(4, 3);
    list.insert1(5, 1);

    list.display();
    // list.displayreverse1();


   }

}


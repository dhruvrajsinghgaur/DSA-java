public class Linkedlist {
   private Node head;
   private Node tail;

   private int size;

    public Linkedlist() {
        this.size = 0;
    }

    public void insertfirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;

    }
    // Method 1 to insert a element in last
    public void insertlast(int val){
        Node node = new Node(val);
        node.next = null;

         if(tail == null){
            head = node;
            tail = node;
        }
        else{
        tail.next = node;
        tail = node;
        }
       
        size += 1;

    }
    
     // Method 2 to insert a element in last
     public void insertlast1(int val){
         if(tail == null){
          insertfirst(val);
          return;
        }
        Node node = new Node(val);
        node.next = null;

        tail.next = node;
        tail = node;
        size += 1;

    }

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
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    // insert an element in linked list using recursion
    public void insertUsingRecursion(int val, int index){
       head = insertUsingRecursion(val, index, head);
    }
    private Node insertUsingRecursion(int value, int index, Node node){
        if (index == 0){
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertUsingRecursion(value, index-1, node.next);
        return node;
    }

    public void deletefirst(){
       
        head = head.next;

        if (head == null){
            tail = null;
        }
        size--;
    }
     public void deletelast(){
       if (size <= 1) {
           deletefirst();
           return;
       }
      Node secondlast = get(size-2);
      tail = secondlast;
      tail.next = null;
      size--;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
           node = node.next;
        }
        return node;
    }

    public void delete(int index){
        if (index == 0){
            deletefirst();
            return;
        }
        if (index == size-1){
            deletelast();
            return;
        }

        Node prev = get(index - 1);
      
        prev.next = prev.next.next;

        size--;
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
        while (temp != null){
            System.out.print("[" + temp.val + "]" + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

 private class Node{
    private int val;
    private Node next;

    public Node(){

    }

    public Node(int val){
        this.val = val;
    }

     public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
 }

 public void reverseLL(Node node){
    if (node == tail){
        node = head;
        return;
    }
    reverseLL(node.next);
    
    tail = node;
    tail.next = null;
 }
 public static void main(String[] args) {

    Linkedlist list1 = new Linkedlist();
    Linkedlist list2 = new Linkedlist();
//     list.insertfirst(2);
//     list.insertfirst(8);
//     list.insertfirst(3);
//     list.insertfirst(9);

//     list.insertlast(4);
//     list.insertlast(5);
//     list.insertlast(6);
//     list.insertlast(7);

//     list.insert(22, 4); 

//     list.deletefirst();
//     list.deletelast();
//     list.delete(3);

//    System.out.println(list.find(4)); 

//     list.display();
        list1.insertlast(1);
        list1.insertlast(2);
        list1.insertlast(3);
        list1.insertlast(4);
        list1.display();
        list1.rotateRight(list1.head, 1);
        list1.display();

        // list2.insertlast(1);
        // list2.insertlast(3);
        // list2.insertlast(5);
        // list2.insertlast(9);
        // list2.display();

       
        //list.problem83();
       // list1.display();
        // list.insertUsingRecursion(7, 3);
        // list.display();

 }
 // questions

  public void problem83(){
        Node node = head;

        while(node != null&&node.next != null){
           if (node.val == node.next.val){
             node.next = node.next.next;
             size--;
            }
            else{
            node = node.next; 
            }
        }
        tail = node;
        tail.next = null;
    }

    public Node Problem21(Node list1, Node list2) {
        Node dummy = new Node();  
        Node tail = dummy;

       
        while (list1 != null && list2 != null) {
             if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
             } 
             else {
                tail.next = list2;
                list2 = list2.next;
             }
            tail = tail.next;
        }
        while (list1 != null){
            tail.next = list1;
            list1 = list1.next;
        }
        while (list2 != null){
            tail.next = list2;
            list2 = list2.next;
        }
    
    return dummy.next;
    }
   


 
}

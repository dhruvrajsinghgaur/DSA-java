



public class MyQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = 0;

    public MyQueue(){
        this(DEFAULT_SIZE);  // this line calls the constructor which has size in argument and passes default size as argument 
    }

    public MyQueue(int size){
        this.data = new int[size];
    }
    
    public boolean insert(int item) throws Exception{
          if (isFull()){
           throw new Exception("cannot insert queue is full!!");
        }
        // we can also use data[ptr++] = item;
        data[ptr] = item;
        ptr++;
        return true;
    }
    public int remove() throws Exception{
         if (isEmpty()){
          throw new Exception("cannot remove queue is empty!!");
        }
        int removed = data[0];
        // Shift all elements to the left
        for (int i = 1; i <= ptr; i++) {
            data[i-1] = data[i];
        }
        ptr--;
       
        return removed;
    }

    public int front() throws Exception{
       if (isEmpty()){
        throw new Exception("cannot remove queue is empty!!");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < ptr; i++) {
            System.out.print(data[i]+" ");
        }
        System.out.println("end");
    }

    public boolean isFull() {
     return ptr == data.length;
    }

    public boolean isEmpty(){
        return ptr == 0; 
    }


    public static void main(String[] args) throws Exception{

        // these are the internal implementation of Queue and Deque provided by java
        // Queue <Integer> queue = new LinkedList<>();
        // queue.add(1);
        // queue.add(2);
        // queue.add(2);
        // queue.add(4);
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        // System.out.println(queue.remove());
        
        // In Deque we can insert and remove element from both the sides
        // Deque<Integer> deque = new ArrayDeque<>();
        // deque.add(2);
        // deque.addFirst(1);
        // deque.addLast(3);
        // System.out.println(deque.remove());
        // System.out.println(deque.removeFirst());
        // System.out.println(deque.removeLast());

        MyQueue queue = new MyQueue(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        
        queue.display();

        CircularQueue queue1 = new CircularQueue(5);
        queue1.insert(1);
        queue1.insert(2);
        queue1.insert(3);
        queue1.insert(4);
        queue1.insert(5);
        
        queue1.display();
       System.out.println(queue1.remove());
         queue1.display();

    }

}
class CircularQueue{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int ptr = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);  // this line calls the constructor which has size in argument and passes default size as argument 
    }

    public CircularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull() {
     return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean insert(int item) throws Exception{
          if (isFull()){
           throw new Exception("cannot insert queue is full!!");
        }
        // we can also use data[ptr++] = item;
        data[ptr] = item;
        ptr = (ptr+1) % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception{
         if (isEmpty()){
          throw new Exception("cannot remove queue is empty!!");
        }
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
       if (isEmpty()){
        throw new Exception("cannot remove queue is empty!!");
        }
        return data[front];
    }
    public void display() throws Exception{
       if (isEmpty()){
        throw new Exception("cannot remove queue is empty!!");
        }
        int i = front;
        do { 
            System.out.print(data[i]+" ");
            i++;
            i = i % data.length;
        } while (i != ptr);
        System.out.println("end");
    }
}

// This Queue will never be full.
class DynamicQueue extends CircularQueue{
    public DynamicQueue(){
        super(); // this will call constructor MyQueue() of parent class here the parent class is MyQueue.
    }

    public DynamicQueue(int size){
        super(size); // this will call constructor MyQueue(int size) of parent class here the parent class is MyQueue.
    }

    @Override
    public boolean insert(int item) throws Exception{
        if (isFull()){
           int[] temp = new int[data.length * 2];

           for (int i = 0; i < data.length; i++) {
               temp[i] = data[(front + i) % data.length];
           }
           front = 0;
           ptr = data.length;
           data = temp;
        }
        return super.insert(item);
    }

}

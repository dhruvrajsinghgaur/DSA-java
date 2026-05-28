public class MyStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public MyStack(){
        this(DEFAULT_SIZE);  // this line calls the constructor which has size in argument and passes default size as argument 
    }

    public MyStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item) throws Exception{
        if (isFull()){
           throw new Exception("cannot push stack is full!!");
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception{
        if (isEmpty()){
          throw new Exception("cannot pop stack is empty!!");
        }
        int popped = data[ptr];
        data[ptr] = 0; // for extra safety keep this line and for preformance focused code you can remove this
        ptr--;
        return popped;
    }

    public int peek() throws Exception{
         if (isEmpty()){
          throw new Exception("cannot peek stack is empty!!");
        }
        return data[ptr];
    }

    public boolean isFull() {
     return ptr == data.length -1; // ptr is at last index 
    }

    public boolean isEmpty(){
        return ptr == -1; 
    }

    public static void main(String[] args) throws Exception { // we have to use throws Exception here also because we are using something in this which throws an exception for example pop() function.

        // this is the default stack provided by java 
        // Stack<Integer> stack = new Stack<>(); 
        // stack.push(4);
        // stack.push(5);
        // stack.push(6);
        // stack.push(7);
        // stack.push(8);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        
        MyStack mystack = new MyStack(5);
        mystack.push(2);
        mystack.push(4);
        mystack.push(6);
        mystack.push(8);
        mystack.push(10);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());

        
        DynamicStack ds = new DynamicStack(5);
        ds.push(2);
        ds.push(4);
        ds.push(6);
        ds.push(8);
        ds.push(10);
        ds.push(12);
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        

        // we can also do this and this will also do the same as above.
        MyStack ds1 = new DynamicStack(5);
        ds1.push(2);
        ds1.push(4);
        ds1.push(6);
        ds1.push(8);
        ds1.push(10);
        ds1.push(12);
        System.out.println(ds1.pop());
        System.out.println(ds1.pop());
        System.out.println(ds1.pop());
        System.out.println(ds1.pop());
        System.out.println(ds1.pop());
        System.out.println(ds1.pop());



    }

  


}
// This stack will never be full.
class DynamicStack extends MyStack {
    public DynamicStack(){
        super(); // this will call constructor MyStack() of parent class here the parent class is MyStack.
    }

     public DynamicStack(int size){
        super(size); // this will call constructor MyStack(int size) of parent class here the parent class is MyStack.
    }

    @Override
    public boolean push(int item) throws Exception{
        if (this.isFull()){
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

       return super.push(item);
     }

}

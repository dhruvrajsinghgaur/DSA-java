
import java.util.Stack;


public class Problem232{

}

class MyQueue {

    private Stack<Integer> first;
    private Stack<Integer> second;


    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int popped = second.pop();

        while (!second.isEmpty()) { 
            first.push(second.pop());
        }
      return popped;
    }
    
    public int peek() {
    while (!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.peek();

        while (!second.isEmpty()) { 
            first.push(second.pop());
        }
      return peeked;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}
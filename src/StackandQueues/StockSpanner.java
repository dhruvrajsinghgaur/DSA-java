package StackandQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Solution classes for LC_901

// This solution uses a monotonic stack and does not revisit the already visited prices
// TC: O(n)
public class StockSpanner{

    class PS{
        int price;
        int span;
    }

    Stack<PS> stack;

    public StockSpanner(){
        stack = new Stack<>();
    }

    public int next(int price){
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            span += stack.pop().span;
        }
        PS ps = new PS();
        ps.price = price;
        ps.span = span;
        stack.push(ps);

        return span;
    }
}

// This solution class revisits even those prices which are already visited
// In worst case like strictly increasing prices or increasing prices TC will become O(n^2)
class StockSpanner1 {

    List<Integer> list;

    public StockSpanner1() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int i = list.size() - 1;
        int span = 0;
        while (i >= 0 && list.get(i) <= price){
            span++;
            i--;
        }
        return span;
    }
}

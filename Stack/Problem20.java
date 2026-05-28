
import java.util.Stack;

public class Problem20 {
    public static void main(String[] args) {
        String str = "[{}]";
        boolean ans = isValid(str);
        System.out.println(ans);
        
    }
    static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
           ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            }
            else{
                if (stack.isEmpty()) return false;
                char top = stack.peek(); 
                if (ch == '}' && top == '{') stack.pop();
                else if (ch == ']' && top == '[') stack.pop();
                else if (ch == ')' && top == '(') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}

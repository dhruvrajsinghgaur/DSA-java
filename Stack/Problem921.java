
import java.util.Stack;

public class Problem921{
    public static void main(String[] args) {
        String str = "()))((";
        int ans = minAddToMakeValid(str);
        System.out.println(ans);
    }
  static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
           if (ch == ')'){
           if (!stack.isEmpty() && stack.peek() == '('){
            stack.pop();
            }
           else {
            stack.push(ch);
           }
          }
          else{
            stack.push(ch);
          }
        }
        return stack.size();
        }
}
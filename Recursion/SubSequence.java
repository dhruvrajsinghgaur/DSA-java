import java.util.ArrayList;

public class SubSequence {
     public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        //subsequencewithAscii(str, ans);
        //System.out.println(subsequence1(str, ans));
        System.out.println(subsequencewithAscii1(str, ans));
      
    }
    // Method 1
    static void subsequence(String str, String ans){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        subsequence(str.substring(1), ans + ch);
        subsequence(str.substring(1), ans);
    }

    // Method 2
    // this method is to return answer in the form of arraylist
      static ArrayList<String> subsequence1(String str, String ans){
        if (str.isEmpty()){
          ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);
    ArrayList<String> left = subsequence1(str.substring(1), ans + ch);
    ArrayList<String> right = subsequence1(str.substring(1), ans);
        left.addAll(right);
        return left;
    }
    // this method returns subsequence with ASCII values 
      static void subsequencewithAscii(String str, String ans){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
       subsequencewithAscii(str.substring(1), ans + ch);
       subsequencewithAscii(str.substring(1), ans);
       subsequencewithAscii(str.substring(1), ans + (ch + 0));
    }

     // this method returns subsequence with ASCII values in the form of arraylist
     static ArrayList<String> subsequencewithAscii1(String str, String ans){
        if (str.isEmpty()){
          ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        char ch = str.charAt(0);
    ArrayList<String> first = subsequencewithAscii1(str.substring(1), ans + ch);
    ArrayList<String> second = subsequencewithAscii1(str.substring(1), ans);
    ArrayList<String> third = subsequencewithAscii1(str.substring(1), ans + (ch+0));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    public static void main(String[] args) {
        String digits = "23";
      // System.out.println(letterCombinations(digits));
      // dicecombinations("",4);
       System.out.println(dicecombinations1("", 4));
  
        
    }
    static List<String> letterCombinations(String digits){
        if(digits.isEmpty()){
            List<String> blank = new ArrayList<>();
            return blank;
        }
        String ans = "";
        return helper(digits, ans);
    }
  private static List<String> helper(String str, String ans){
        if (str.isEmpty()){
          List<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
       
        char ch = str.charAt(0);
        char ch1 = 0 ;
        char ch2 = 0;
        char ch3 = 0;
        char ch4 = 0;

        if(ch == '2'){
            ch1 = 'a';
            ch2 = 'b';
            ch3 = 'c';
        }
         if(ch == '3'){
            ch1 = 'd';
            ch2 = 'e';
            ch3 = 'f';
        }
         if(ch == '4'){
            ch1 = 'g';
            ch2 = 'h';
            ch3 = 'i';
        }
         if(ch == '5'){
            ch1 = 'j';
            ch2 = 'k';
            ch3 = 'l';
        }
         if(ch == '6'){
            ch1 = 'm';
            ch2 = 'n';
            ch3 = 'o';
        }
         if(ch == '7'){
            ch1 = 'p';
            ch2 = 'q';
            ch3 = 'r';
            ch4 = 's';
        }
         if(ch == '8'){
            ch1 = 't';
            ch2 = 'u';
            ch3 = 'v';
        }
         if(ch == '9'){
            ch1 = 'w';
            ch2 = 'x';
            ch3 = 'y';
            ch4 = 'z';
        }
        
    if(!(ch == '7'||ch=='9')){
    List<String> f = helper(str.substring(1), ans + ch1);
    List<String> s = helper(str.substring(1), ans+ ch2);
    List<String> t = helper(str.substring(1), ans+ ch3);
  
        f.addAll(s);
        f.addAll(t);

         return f;
    }
    else{
        List<String> f = helper(str.substring(1), ans + ch1);
        List<String> s = helper(str.substring(1), ans+ ch2);
        List<String> t = helper(str.substring(1), ans+ ch3);
        List<String> fo = helper(str.substring(1), ans+ ch4);
       
        f.addAll(s);
        f.addAll(t);
        f.addAll(fo);

         return f;
    }

       
    }
    
    // this method directly prints answers
    static void dicecombinations(String p, int up){
         if (up == 0){
            System.out.println(p);
            return;
         }
        
         for (int i = 1; i <= 6 && i <= up; i++) {
            dicecombinations(p+i, up-i); 
         }
    }
    
    // this method returns an arraylist
  static ArrayList<String> dicecombinations1(String p, int up){
         if (up == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
         }
         ArrayList<String> list = new ArrayList<>();
         for (int i = 1; i <= 6 && i <= up; i++) {
            list.addAll(dicecombinations1(p+i, up-i));
         }
         return list;
    }
    
    // this program is for dice with different faces 
    static void diceface(String p, int up, int face){
        if (up == 0){
            System.out.println(p);
            return;
         }
        
        for (int i = 1; i <= face && i <= up; i++) {
            diceface(p+i, up-i, face); 
         }
    }
      // this program is for dice with different faces and returns an arraylist
      static ArrayList<String> diceface1(String p, int up, int face){
         if (up == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
         }
         ArrayList<String> list = new ArrayList<>();
         for (int i = 1; i <= face && i <= up; i++) {
            list.addAll(diceface1(p+i, up-i, face));
         }
         return list;
    }
}

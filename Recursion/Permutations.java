
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        String empty = "";
        
        permutations(empty, str);
        ArrayList<String> result = permutations1(empty, str);

        System.out.println(result);
        // this will print the no. of permutations by counting the no. of strings in the arraylist
        System.out.println("No. of permutations are "+result.size());
        //  this will also return the no. of permutations by using function
        System.out.println("No. of permutations are "+permutationsCount(empty, str));
    }
    
    static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }

     static ArrayList<String> permutations1(String p,String up){
        if(up.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(p);
            return list;
        }
         ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutations1(f+ch+s, up.substring(1)));
        }

        return ans;
    }

    // this program returns the no. of permutations
    static int permutationsCount(String p,String up){
        if(up.isEmpty()){
           
            return 1;
        }

         int count = 0;
        char ch = up.charAt(0);
       
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
           count = count + permutationsCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}

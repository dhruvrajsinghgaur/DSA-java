public class BasicStringQuestions {
    public static void main(String[] args) {
        String str = "bacapplecad";
        String ans = "";
        removeA(str, ans);
        System.out.println(SkipAppNotApple(str));

       
        
    }
    // Method 1
    static void removeA(String str, String ans){
        if (str.isEmpty()){
             System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch =='a'){
            removeA(str.substring(1),ans);
        }
        else{
            removeA(str.substring(1),ans + ch);
        }
    }
    // Method 2
     static String removeA(String str){
        if (str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if (ch =='a'){
          return removeA(str.substring(1));
        }
        else{
          return ch + removeA(str.substring(1));
        }
       
    }
    // This method skips an string
     static String SkipApple(String str){
        if (str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if (str.startsWith("apple")){
          return SkipApple(str.substring(5));
        }
        else{
          return ch + SkipApple(str.substring(1));
        }
       
    }
    // skips app only when its not apple
    static String SkipAppNotApple(String str){
        if (str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if (str.startsWith("app") && !str.startsWith("apple")){
          return SkipAppNotApple(str.substring(3));
        }
        else{
          return ch + SkipAppNotApple(str.substring(1));
        }
       
    }
}


public class DigitsInNum {
    public static void main(String[] args) {
        digits(23244, 10);
    }
    static void digits(int n,int b){
        int formula ;

        formula = (int)((Math.log(n)/Math.log(b))+1);

        System.out.println(formula);
    }
}

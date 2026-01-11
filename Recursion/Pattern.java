public class Pattern {
    public static void main(String[] args) {
       // pattern3 and pattern1 are same
       
        pattern1(4, 0);
         pattern2(0, 0, 4);
       pattern3(5, 1);
      pattern4(1, 4);

    }
    
    static void pattern1(int r, int c){
        if (r == 0){
            return;
        }
        if(c<r){
            System.out.print("*");
            pattern1(r, c+1);

        }
        if(c>=r){
            System.out.println();
            pattern1(r-1, 0);
        }
    }

    static void pattern2(int r, int c,int n){
        if (r > n){
            return;
        }
        if(r >= c){
            System.out.print("*");
            pattern2(r, c+1, n);

        }
        if(c>r){
            System.out.println();
            pattern2(r+1, 0, n);
        }
    }
static void pattern3(int r, int c){
        if (r == 0){
            return;
        }
        if(c<r){
            System.out.print("*");
            pattern3(r, c+1);
        }
       else{
            System.out.println();
            pattern3(r-1, 1);
       }
    }

    static void pattern4(int r, int c){
        if (r == 5){
            return;
        }
        if (c>0){
        if(c>r){
            System.out.print(" ");
        }
        else{
             System.out.print("*");
        }
         pattern4(r, c-1);
    }
       else{
            System.out.println();
            pattern4(r+1, 4);
       }
    }

  

}

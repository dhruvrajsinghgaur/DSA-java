
public class ASCIIvalue {
    public static void main(String[] args) {
        //AsciiToChar(48);
        CharToAscii('a');

       // direct method
        char ch ='a';
        System.out.println((ch+0));

       

    }
    // this convertes a character into its ascii value
    static void CharToAscii(char ch){
        int a = (int) ch;
        System.out.println("ASCII value of "+ ch +" is "+a); 
    }

    // this converts a ascii value into character 
     static void AsciiToChar(int n){
        char ch = (char) n;
        System.out.println("character value of "+n+" is "+ch);
    }
}

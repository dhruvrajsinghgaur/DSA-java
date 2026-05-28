package HuffmanCoding;

public class Main {
    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        HuffmanCode hf = new HuffmanCode(str);
        String codedstring = hf.encoder(str);
        System.out.println(codedstring);
        String decodedstring = hf.decoder(codedstring);
        System.out.println(decodedstring);
    }
}

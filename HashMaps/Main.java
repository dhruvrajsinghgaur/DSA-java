package HashMaps;

public class Main {
    public static void main(String[] args){
        String text = "abdcgsjdb";
        String pattern = "abdc";
        KarpRabin karp = new KarpRabin();
        karp.search(text, pattern);
    }
}

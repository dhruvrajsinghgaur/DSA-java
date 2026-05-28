package HashMaps;

public class KarpRabin {
    private static final int PRIME = 101;
    private static final long MOD = 1_000_000_007;
    public double calculateHash(String str){
        double hash = 0;
        for(int i=0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }
    public double updateHash(double prevHash, char oldchar, char newchar, int patternLenght){
        double newhash = ((prevHash - oldchar)/PRIME);
        newhash = newhash + newchar*Math.pow(PRIME, patternLenght - 1);
        return newhash;
    }

    public void search(String text, String pattern){
    int patternLength = pattern.length();
    double patternhash = calculateHash(pattern);
    double texthash = calculateHash(text.substring(0, patternLength));
    boolean a = false;

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (texthash == patternhash){
                if (text.substring(i, i + patternLength).equals(pattern)){
                    a = true;
                    System.out.println("pattern found from index " + i + " to index " + (i + patternLength - 1) + ".");
                }
            }
            if (i < text.length() - patternLength) {
                texthash = updateHash(texthash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
        if (a == false) System.out.println("pattern not found");

    }
}

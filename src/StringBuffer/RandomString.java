package StringBuffer;
import java.lang.StringBuffer;
import java.util.Random;
class RandomString {

    public static  String generate(int n){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int chr = (97 + random.nextInt(1,26));
            sb.append((char)chr);
        }
        return sb.toString();
    }

}
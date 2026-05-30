package Patterns.SlidingWindow;

public class LC_05 {
    public static String longestPalindrome(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);

            int length = Math.max(len1, len2);

            if (length > str.length()) {

                if (length % 2 != 0) {
                    length--;
                    length = length / 2;
                    str = s.substring(i - length, i + length + 1);
                } else {
                    length = length / 2;
                    str = s.substring(i - length + 1, i + length + 1);
                }
            }
        }
        return str;
    }
    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
       return right - left - 1;
    }
    public static void main(String[] args){
      String str = "babad";
      System.out.println(longestPalindrome(str));
    }
}

package Patterns.SlidingWindow;

import java.util.ArrayList;

public class LC_05 {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        ArrayList<Integer> pA = new ArrayList<>();
        helper(s, left, right);

        return "";
    }
    private void helper(String s, int left, int right){
        ArrayList<Integer> pA = new ArrayList<>();
        while (left <= right) {
            if (left == right) {
                pA.add(left);
                return;
            }
            else if (s.charAt(left) == s.charAt(right)) {
                pA.add(left);
                pA.add(right);
                left++;
                right--;
            }
            else if (s.charAt(left) != s.charAt(right)) {
                helper(s, left++, right);
                helper(s, left, right--);
            }
        }
    }
}

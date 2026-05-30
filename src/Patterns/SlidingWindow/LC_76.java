package Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            count[ch]++;
        }

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        int requirement = t.length();

        while(right < s.length()){

            char r = s.charAt(right);

            if (count[r] > 0){
                requirement--;
            }

            count[r]--;
            right++;

            while(requirement == 0){

                if (right - left < minLength){
                    minLength = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                count[l]++;

                if (count[l] > 0){
                    requirement++;
                }

                left++;
            }

        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);

    }
    void main(){
        String s = "ABCD";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}

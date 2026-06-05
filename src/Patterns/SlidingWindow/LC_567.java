package Patterns.SlidingWindow;

import java.util.Arrays;

public class LC_567 {

    // Method 1.
    // Less complex than method 2 but both have same complexity.
    // TC: O(n).
    public boolean checkInclusion(String s1, String s2){
        if (s1.length() > s2.length()) return false;

        int[] needCount = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            needCount[ch - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= k){
                window[s2.charAt(i - k) - 'a']--;
            }
            if (Arrays.equals(needCount, window)) return true;
        }

        return false;
    }

    // Method 2.
    // This method uses same logic as LC_76.
    // TC: O(n).
    public boolean checkInclusion1(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] countS1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;

        int requirement = s1.length();

        int minLength = Integer.MAX_VALUE;

        while(right < s2.length()){

            int r = s2.charAt(right) - 'a';

            if (countS1[r] > 0){
                requirement--;
            }

            countS1[r]--;

            while(requirement == 0){

                int l = s2.charAt(left) - 'a';

                countS1[l]++;

                if (countS1[l] > 0){

                    if (minLength > right - left) minLength = right - left;

                    requirement++;
                }
                left++;
            }
            right++;
        }
        return s1.length() == minLength + 1;
    }
}

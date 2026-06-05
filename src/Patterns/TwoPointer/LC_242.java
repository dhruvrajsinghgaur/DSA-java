package Patterns.TwoPointer;

import java.util.Arrays;

public class LC_242 {
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) return false;
        }

        return true;
    }

    public boolean isAnagram1(String s, String t){
        if (s.length() != t.length()) return false;

        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < countS.length; i++) {
            if(countS[i] != countT[i]) return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        Arrays.sort(chS);
        Arrays.sort(chT);

        for(int i = 0; i < chS.length; i++){
            if (chS[i] != chT[i]) return false;
        }
        return true;
    }

}

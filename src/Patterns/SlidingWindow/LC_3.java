package Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_3 {

    // Method 1.
    // TC: O(n).
    public static int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Method 2.
    // TC: O(n*k).
    // TC: O(n^2) in worst case.
    public static int lengthOfLongestSubstring1(String s){
        List<Character> charArr = new ArrayList<>();
        int maxLength = 0;
        int sPointer = 0;
        while(sPointer < s.length()){
            char ch = s.charAt(sPointer);
            if (!charArr.contains(ch)) {
                charArr.add(ch);
                maxLength = Math.max(maxLength, charArr.size());
                sPointer++;
            }
            else{
                int indexOfCh = indexFinder1(charArr, ch);
                for (int i = 0; i <= indexOfCh; i++) {
                    charArr.remove(0);
                }
            }
        }
        return maxLength;
    }
    private static int indexFinder1(List<Character> s, char ch){
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == ch) return i;
        }
        return -1;
    }


    // not a leetCode question.
    public static  int lengthOfLongestSubstringInAlphabeticalOrder(String s) {
        String ao = "abcdefghijklmnopqrstuvwxyz";
        int maxLength = 0;
        int sPointer = 0;
        int aoPointer = 0;
        String str = "";
        while (sPointer < s.length()){
            if (s.charAt(sPointer) == ao.charAt(aoPointer)){
                str = str + s.charAt(sPointer);
                maxLength = Math.max(maxLength,str.length());
                sPointer++;
                if (aoPointer < 25) aoPointer++;
            }
            else if (s.charAt(sPointer) != ao.charAt(aoPointer)){
                str = "";
                aoPointer = indexFinder(s.charAt(sPointer), ao);
                if (aoPointer == -1) {
                    return -1;
                }
            }
        }
        return maxLength;
    }

    private static int indexFinder(char ch, String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String s = "anviaj";
        System.out.println(lengthOfLongestSubstring(s));
    }

}

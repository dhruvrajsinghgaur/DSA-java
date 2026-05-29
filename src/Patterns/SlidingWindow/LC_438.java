package Patterns.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_438 {
    // Method 1.
    // Optimal Method TC: O(n).
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> answer = new ArrayList<>();
        int[] pCount = new int[26];
        int[] window = new int[26];

        if (p.length() > s.length()) return answer;

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, window)) answer.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, window)) answer.add(i - p.length() + 1);
        }
        return answer;
    }
    // Method 2.
    // valid sol but TC is O(mn) and gives TLE on leetCode.
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < p.length(); j++){
                char ch = p.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            boolean valid = true;
            for (int j = 0; j < p.length(); j++) {
                char ch = s.charAt(i + j);
                if (!map.containsKey(ch)) {
                    valid = false;
                    break;
                }
                int x = map.get(ch);
                if (x - 1 == 0) map.remove(ch);
                else map.put(ch, x - 1);
            }
            if (valid && map.isEmpty()) answer.add(i);
        }
        return answer;
    }

    void main(String[] args){

        String s = "abaacbabc";
        String p = "abc";

        System.out.println(findAnagrams(s, p));

//        String str = "ABCD BCDA";
//
//        System.out.println(hasAnagram(str));


    }

    // not exactly same question as LC 438 but similar.
    public String hasAnagram(String str){
        String[] s = str.split(" ");

        for (int i = 1; i < s.length; i++) {
            String temp1 = s[i];
            String temp2 = s[i - 1];
            if (temp1.length() != temp2.length()) continue;

            boolean[] used = new boolean[temp2.length()];
            int maxLength = 0;
            for (int j = 0; j < temp2.length(); j++) {
                for (int k = 0; k < temp2.length(); k++) {
                    if (!used[k] && temp1.charAt(j) == temp2.charAt(k)){
                        used[k] = true;
                        maxLength++;
                        break;
                    }
                }
            }
            if (maxLength == temp2.length()) return temp1 + " " + temp2;
        }
        return "NO ANAGRAM";
    }
}

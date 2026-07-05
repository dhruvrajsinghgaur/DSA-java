package Patterns.intervals;

import java.util.List;

public class LC_139 {

    // Method 0. (method 1 + memo)
    // TC: O(m * n * l). (m == wordDict.size(), n == s.length(), l == max word length)
    // SC: O(n).
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, wordDict, 0, memo);
    }
    private boolean helper(String s, List<String> wordDict, int startIndex, Boolean[] memo){
        if (startIndex == s.length()) return true;
        if (memo[startIndex] != null) return memo[startIndex];
        for (String word : wordDict){
            // if (startIndex + word.length() <= s.length() && s.substring(startIndex, startIndex + word.length()).equals(word)) {
            //      if (helper(s, wordDict, startIndex + word.length(), memo)) return memo[startIndex] = true;
            // }
            if (s.startsWith(word, startIndex)){
                if (helper(s, wordDict, startIndex + word.length(), memo)) return memo[startIndex] = true;
            }
        }
        return memo[startIndex] = false;
    }

    // Method 1. (instead of creating entire word from scratch like method 2 it maintains a index)
    // TC: O(2^n). (worst case)
    // SC: O(n).
    public boolean wordBreak1(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }
    private boolean helper(String s, List<String> wordDict, int startIndex){
        if (startIndex == s.length()) return true;
        boolean ans = false;
        for (String word : wordDict){
            if (startIndex + word.length() <= s.length() && s.substring(startIndex, startIndex + word.length()).equals(word)) {
                ans = ans || helper(s, wordDict, startIndex + word.length());
            }
        }
        return ans;
    }

    // Method 2. (this method creates string from words in wordDict and try to match every possible word that can be created from the wordDict)
    // TC: O(m^n). (m == wordDict.size() and n == s.length() / averageWordLength)
    public boolean wordBreak2(String s, List<String> wordDict) {
        return helper(s, wordDict, "");
    }
    private boolean helper(String s, List<String> wordDict, String checker) {
        if (checker.equals(s)) return true;
        if (checker.length() >= s.length()) return false;

        boolean ans = false;
        for (int i = 0; i < wordDict.size(); i++) {
            ans = ans || helper(s, wordDict, checker + wordDict.get(i));
        }
        return ans;
    }
}

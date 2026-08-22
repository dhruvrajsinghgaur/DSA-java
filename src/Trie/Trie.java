package Trie;

// Trie Implementation.
// Also a solution for LC_208.
public class Trie {
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) {
            int index = ch - 'a';
            if (curr.childrens[index] == null) curr.childrens[index] = new TrieNode();
            curr = curr.childrens[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for (char ch : wordArr) {
            int index = ch - 'a';
            if (curr.childrens[index] == null) return false;
            curr = curr.childrens[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] wordArr = prefix.toCharArray();

        for (char ch : wordArr) {
            int index = ch - 'a';
            if (curr.childrens[index] == null) return false;
            curr = curr.childrens[index];
        }
        return true;
    }
}
class TrieNode {
    TrieNode[] childrens = new TrieNode[26];
    boolean isEnd;
}

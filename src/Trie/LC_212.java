package Trie;

import java.util.ArrayList;
import java.util.List;

public class LC_212 {

    // {w = no. of words, r = rows in board, c = columns in board, l = max word length, s = total no. of characters in all words}

    // Method 0. (trie + dfs + backtracking)
    // TC: O(r * c + 4^l).
    // SC: O(s + r * c + l).
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> answers = new ArrayList<>();
        for (String word : words) trie.insert(word);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[i].length];
                search(board, i, j, trie.root, visited, answers, "");
            }
        }
        return answers;
    }
    private void search(char[][] board, int i, int j, TrieNode node, boolean[][] visited, List<String> answers, String s) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return;
        if (visited[i][j]) return;
        char ch = board[i][j];
        int index = ch - 'a';
        if (node.childrens[index] == null) return;
        node = node.childrens[index];
        s = s + ch;
        if (node.isEnd) {
            answers.add(s);
            node.isEnd = false;
        }
        visited[i][j] = true;
        search(board, i + 1, j, node, visited, answers, s);
        search(board, i, j + 1, node, visited, answers, s);
        search(board, i - 1, j, node, visited, answers, s);
        search(board, i, j - 1, node, visited, answers, s);
        visited[i][j] = false;
    }

    // Method 1. (dfs + backtracking)
    // {recursion stack at max can be equal to max word length l}
    // TC: O(w * r * c * 4^l).
    // SC: O(r * c + l).
    public List<String> findWords1(char[][] board, String[] words) {
        List<String> answers = new ArrayList<>();
        for (String word : words) {
            boolean isPresent = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    if (search1(board, word, 0, i, j, visited)) {
                        answers.add(word);
                        isPresent = true;
                        break;
                    }
                }
                if (isPresent) break;
            }
        }
        return answers;
    }
    private boolean search1(char[][] board, String word, int wi, int i, int j, boolean[][] visited){
        if (wi == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(wi)) return false;
        visited[i][j] = true;
        boolean down = search1(board, word, wi + 1, i + 1, j, visited);
        boolean right = search1(board, word, wi + 1, i, j + 1, visited);
        boolean up = search1(board, word, wi + 1, i - 1, j, visited);
        boolean left = search1(board, word, wi + 1, i, j - 1, visited);
        visited[i][j] = false; // backtrack
        return down || right || up || left;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        LC_212 solution = new LC_212();

        List<String> result = solution.findWords(board, words);

        System.out.print(result);
    }
}

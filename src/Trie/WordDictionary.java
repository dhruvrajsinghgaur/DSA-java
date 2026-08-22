package Trie;

// Also the solution of LC_211.
public class WordDictionary {

    DictionaryNode root;

    public WordDictionary() {
        root = new DictionaryNode();
    }

    public void addWord(String word) {
        DictionaryNode curr = root;

        for (char ch : word.toCharArray()){

            int index = ch - 'a';

            if (curr.childrens[index] == null) curr.childrens[index] = new DictionaryNode();

            curr = curr.childrens[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        DictionaryNode curr = root;
        char[] arr = word.toCharArray();
        return searchHelp(curr, arr, 0);
    }

    private boolean searchHelp(DictionaryNode curr, char[] arr, int i) {
        if (i == arr.length) return curr.isEnd;

        if (arr[i] == '.') {
            for (int j = 0; j < 26; j++) {
                if (curr.childrens[j] != null) {
                    boolean subAns = searchHelp(curr.childrens[j], arr, i + 1);
                    if (subAns) return true;
                }
            }
            return false;
        }

        int index = arr[i] - 'a';

        if (curr.childrens[index] == null) return false;

        return searchHelp(curr.childrens[index], arr, i + 1);
    }
}
class DictionaryNode {
    DictionaryNode[] childrens = new DictionaryNode[26];
    boolean isEnd;
}

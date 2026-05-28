package Trees;
import java.util.*;
public class Problem127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int transformation = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            transformation++;
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp[j] = c;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) return transformation;
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

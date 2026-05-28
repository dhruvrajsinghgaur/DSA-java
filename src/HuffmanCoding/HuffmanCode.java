package HuffmanCoding;

import Heaps.Heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HuffmanCode {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency.
        Node left;
        Node right;

        public Node (Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }
    }
    // this function creates frequency map.
    public HuffmanCode(String feeder) throws Exception {
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            if (fmap.containsKey(cc)){
                int ov = fmap.get(cc);
                fmap.put(cc, ov + 1);
            }
            else {
                fmap.put(cc, 1);
            }
        }
        Heap<Node> minheap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minheap.insert(node);
        }

        while(minheap.size() != 1) {
            Node first = minheap.remove();
            Node second = minheap.remove();
            Node newnode  = new Node('\0', first.cost + second.cost);
            newnode.left = first;
            newnode.right = second;
            minheap.insert(newnode);
        }

        Node ft = minheap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initencoderdecoder(ft, "");
    }

    private void initencoderdecoder(Node ft, String prefix){
        if (ft == null) return;
        if (ft.left == null && ft.right == null) {
            this.encoder.put(ft.data, prefix);
            this.decoder.put(prefix, ft.data);
        }
        initencoderdecoder(ft.left, prefix + "0");
        initencoderdecoder(ft.right, prefix + "1");
    }

    public String encoder(String source){
        String ans = "";
        for (int i = 0; i < source.length(); i++) {
            ans = ans + this.encoder.get(source.charAt(i));
        }
        return ans;
    }
    public String decoder(String codedstring){
        String key = "";
        String ans = "";
        for (int i = 0; i < codedstring.length(); i++) {
            key = key + codedstring.charAt(i);
            if (this.decoder.containsKey(key)){
                ans = ans + this.decoder.get(key);
                key = "";
            }
        }
        return ans;
    }
}

package Graph;

public class DisjointSet {
        int[] parent;

        DisjointSet(int v){
            parent = new int[v];
            for(int i = 0; i < v; i++) parent[i] = i;
        }

        public int find(int i){
            if (parent[i] != i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j){
            int pi = find(i);
            int pj = find(j);

            if (pi == pj) return;

            parent[pi] = pj;
        }
}

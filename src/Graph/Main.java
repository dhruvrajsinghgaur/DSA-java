package Graph;

public class Main {
    public static void main(String[] args) {

//        Graph1 gh = new Graph1(5);
//        gh.addEdge(0, 1);
//        gh.addEdge(0, 3);
//        gh.addEdge(1, 2);
//        gh.addEdge(2, 3);
//        gh.addEdge(2, 4);
//        gh.addEdge(3, 4);
//        gh.printGraph();
//        gh.BFS(0);
//        System.out.println();
//        gh.DFS(0);
//
//        System.out.println();
//
//        Graph2 gh1 = new Graph2(4);
//        gh1.addEdge(0, 1);
//        gh1.addEdge(0, 2);
//        gh1.addEdge(0, 3);
//        gh1.addEdge(1, 2);
//        gh1.addEdge(1, 3);
//        gh1.addEdge(2, 3);
//
//        gh1.printGraph();


//

        int ans = FindD(17,3120);
        System.out.println(ans);

    }


    public static int FindD(int e, int phiN){
        int d = 1;
        while((e * d) % phiN != 1) d++;
        return d;
    }
}

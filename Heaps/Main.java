package Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(2);
        heap.insert(1);
        heap.insert(9);
        heap.insert(8);
        heap.insert(3);

        ArrayList<Integer> list = heap.heapsort();
        System.out.println(list);

//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());


    }
}

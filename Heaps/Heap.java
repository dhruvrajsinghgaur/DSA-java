package Heaps;
import java.util.ArrayList;
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> list;
    public Heap(){
    list = new ArrayList<>();
    }
    private void swap(int i, int j){
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int parent(int index){
        return (index-1)/2;
    }
    public int leftchild(int index){
        return index*2+1;
    }
    public int rightchild(int index){
        return index*2+2;
    }
    public int size(){ return list.size(); }

    // this method lets you insert an element in min heap.
    public void insert(T value){
        list.add(value);
        upheap(list.size() - 1);
    }
    private void upheap(int index){
        if (index == 0) return;
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index,p);
            upheap(p);
        }
    }
    // this method lets you remove an element from min heap;
    public T remove() throws Exception{
        if (list.isEmpty()) throw new Exception("Heap is Empty!");
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int index){
        int min = index;
        int left = leftchild(index);
        int right = rightchild(index);
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }
        if (min != index){
            swap(min, index);
            downheap(min);
        }
    }
    // heapsort.
    public ArrayList<T> heapsort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}

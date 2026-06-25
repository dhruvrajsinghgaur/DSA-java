package StackandQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// Solution 0.
// TC: O(logn) for add() and O(1) and for findMedian()
// standard two heap method
public class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || left.peek() >= num){
            left.offer(num);
        } else {
            right.offer(num);
        }
        if (left.size() > right.size() + 1) right.offer(left.poll());
        if (right.size() > left.size()) left.offer(right.poll());
    }

    public double findMedian() {
        int totalSize = left.size() + right.size();
        if (totalSize % 2 == 0){
           return ((double) left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}

// Solution 1.
// TC: O(n) for add() and O(1) and for findMedian()
// uses binary search to find correct position of inserting num
class MedianFinder1 {
    List<Integer> list;

    public MedianFinder1() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = Collections.binarySearch(list, num);
        if (index < 0) index = -(index + 1);
        list.add(index, num);
    }

    public double findMedian() {
        double median = 0;
        if (list.size() % 2 == 0) {
            median = list.get(list.size()/2);
            median += list.get(list.size()/2 - 1);
            median /= 2;
        }
        else{
            median = list.get((list.size()/2));
        }
        return median;
    }
}

// Solution 2.
// TC: O(n logn) for add() and O(1) and for findMedian()
// sorts entire arr every time we insert a new num
class MedianFinder2 {

    List<Integer> list;

    public MedianFinder2() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int index = Collections.binarySearch(list, num);
        if (index < 0) index = -(index + 1);
        list.add(index, num);
    }

    public double findMedian() {
        int median = 0;
        if (list.size() % 2 == 0) {
            median = list.get(list.size()/2);
            median += list.get(list.size()/2 - 1);
            median /= 2;
        }
        else{
            median = list.get((list.size()/2));
        }
        return median;
    }
}

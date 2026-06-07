package LinkedList;

public class LC_19 {
    // Methos 1.
    // TC: O(N).
    // One Pass solution.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    // Methos 2.
    // TC: O(N).
    // Two Pass solution.
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode nodeLeft = head;
        ListNode nodeRight = head;
        int counter = 0;
        while (nodeRight.next != null){
            nodeRight = nodeRight.next;
            counter++;
        }
        int length = counter + 1;
        if (length == n) return head.next;
        for(int i = 1; i < counter - n + 1; i++){
            nodeLeft = nodeLeft.next;
        }
        nodeLeft.next = nodeLeft.next.next;
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Problems {
    class ListNode {
      int val;
      ListNode next;

        public ListNode() {
        }
      
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
   public boolean problem141(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
       while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow){
            return true;
        }
       }
        return false;
    }


    public int lengthofcycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        int count = 0;

       while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow){
          do { 
              slow = slow.next;
              count++;
          } while (fast != slow);

            return count;
        }
       }
        return 0;
    }

     public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            if (fast == 1 || slow == 1){
                return true;
            }
            fast = findsqr(findsqr(fast));

        }while(fast != slow);

        return false;
    }
    private int findsqr(int num){
        int ans = 0;
        while(num > 0){
            int rem = num % 10;
            ans = ans + rem*rem;
            num = num/10;
        }
        return ans;
    }

     public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left ,right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();  
        ListNode tail = dummy;

       
        while (list1 != null && list2 != null) {
             if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
             } 
             else {
                tail.next = list2;
                list2 = list2.next;
             }
            tail = tail.next;
        }
        while (list1 != null){
            tail.next = list1;
            list1 = list1.next;
        }
        while (list2 != null){
            tail.next = list2;
            list2 = list2.next;
        }
    
    return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
      
    }

   
     public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next;

        while (present != null) {
            next = present.next; // This must be *inside* the loop!
            present.next = prev;
            prev = present;
            present = next;
        }
        return prev;
    }
    
     public ListNode reverseKGroup(ListNode head, int k) {
        for (int i = 0 ; i <= k; i = i+k){
            reverseBetween(head, i, i+k-1);
        }
        return head;
        
    }
     public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;

        for(int i = 0; current != null && i < left-1; i++){
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        ListNode next = current.next;
        for(int i = 0; current != null && i < right-left+1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if (next != null){
                next = next.next;
            }
        }

        if (last != null){
            last.next = prev;
        }
        else{
            head = prev;
        }

        newEnd.next = current;

        return head;
    }
    public ListNode rotateRight(ListNode head, int k){
     if (k<=0 || head == null || head.next == null) return head;
      ListNode last = head;
      int length = 1;
      while (last.next != null){
        last = last.next;
        length = length + 1;
      }

      last.next = head;
      int rotations = k % length;
      int skip = length - rotations;
      ListNode newlast = head;
      for (int i = 0; i < skip - 1; i++) {
        newlast = newlast.next;
      }
      head = newlast.next;
      newlast.next = null;

      return head;

      
     }
    
     
    }

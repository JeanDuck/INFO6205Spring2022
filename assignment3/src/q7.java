public class q7 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
     }
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while(head!=null){
            odd.next=head;
            even.next=head.next;
            head=head.next==null?null:head.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead.next;
        return oddHead.next;
    }

}

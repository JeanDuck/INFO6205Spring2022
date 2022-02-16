public class q7 {
    public class ListNode {
        ListNode next;
        int val;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        ListNode cur=head;
        ListNode pre=null;
        while(left>1){
            pre=cur;
            cur=cur.next;
            left--;
            right--;
        }
        ListNode con=pre;
        ListNode tail=cur;
        while(right>0){
            ListNode third=cur.next;
            cur.next=pre;
            pre=cur;
            cur=third;
            right--;
        }
        if(con!=null){
            con.next=pre;
        }else{
            head=pre;
        }
        tail.next=cur;
        return head;

    }
}

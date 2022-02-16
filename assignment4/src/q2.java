public class q2 {
    public class ListNode {
        ListNode next;
        int val;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode pre1 = new ListNode(-1);
        ListNode dummy1 = pre1;
        ListNode pre2 = new ListNode(-1);
        ListNode dummy2 = pre2;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                pre1.next=cur;
                pre1=pre1.next;
            }else{
                pre2.next=cur;
                pre2=pre2.next;
            }
            cur=cur.next;
        }

        pre2.next=null;
        pre1.next=dummy2.next;
        return dummy1.next;
    }
}

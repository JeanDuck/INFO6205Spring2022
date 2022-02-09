import java.util.*;
public class q5 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode nex=slow.next;
        slow.next=null;
        ListNode start1=head;
        ListNode start2=reverse(nex);
        while(start1!=null&&start2!=null){
            if(start1.val!=start2.val) return false;
            start1=start1.next;
            start2=start2.next;
        }
        return true;

    }
    public ListNode reverse(ListNode node){
        ListNode pre=null;
        ListNode cur=node;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}

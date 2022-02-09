import java.util.*;
public class q4 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public void reorderList(ListNode head) {
        /*
        clarify:
        1. i can use a pre pointer and a cur pointer, and i will move the currrent pointer, until cur.next=null, then i  will connect the pre pointer with the cur pointer
        1->2->3->4->5
        initially thr pre pointer will be located at 1,  and i will store the remaining nodes in temp
        temp 2->3>4>5
        then the cu2 pointer will start at temp ,  cur2=node(5),cur1=node(4)
        pre.next=cur2, cur2.next=temp,cur1.next=null
        pre:1->5->2->3->4
        temp:2->3->4
        cur2=temp
        pre=temp
        temp=pre.next


        the above methods seems didn't work
        right method:
         reverse the second part of the list
        */
        if(head==null||head.next==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow pointer will loacated at the middle
        ListNode pre=null;
        while(slow!=null){
            ListNode temp=slow.next;
            slow.next=pre;
            pre=slow;
            slow=temp;
        }

        ListNode first=head;
        ListNode second=pre;
        while(second.next!=null){
            ListNode temp=null;
            temp=first.next;
            first.next=second;
            first=temp;

            temp=second.next;
            second.next=first;
            second=temp;

        }

    }
}

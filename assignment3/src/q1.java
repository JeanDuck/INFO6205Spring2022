import java.util.*;
public class q1 {

    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        //store the start of the new list,and i will move the cur pointer
        ListNode cur=head;
        int curry=0;
        while(l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int temp=x+y+curry;
            if(temp>=10){
                curry=1;
                //obtain the remainder of temp divided by 10
                temp=temp%10;
            }else{
                curry=0;
            }
            ListNode newNode=new ListNode(temp);
            cur.next=newNode;
            cur=cur.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(curry==1){
            cur.next=new ListNode(curry);
            cur=cur.next;
        }
        return head.next;

    }
    public ListNode reverse(ListNode list){
        ListNode pre=null;
        ListNode cur=list;
        while(cur!=null){
            //we use a temp to record the next element after the cur
            ListNode temp=cur.next;
            //reverse the pointer
            cur.next=pre;
            pre=cur;
            //move the cur pointer to the next element
            cur=temp;
        }
        return pre;
    }
}

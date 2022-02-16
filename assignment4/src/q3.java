import java.util.*;
public class q3 {
    public class ListNode {
        ListNode next;
        int val;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode temp = head;
        int num=1;
        while(temp!=null)
        {
            int count=0;
            ListNode start = temp;
            Stack st = new Stack();

            while(count!=num && temp!=null)
            {
                st.push(temp.val);
                temp=temp.next;
                count++;

            }

            if(count%2==0)
            {
                while(temp!=start)
                {
                    start.val=(int) st.pop();
                    start=start.next;
                }

            }

            num++;
        }


        return head;

    }
}

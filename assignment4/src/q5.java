public class q5 {
    public class ListNode {
        ListNode next;
        int val;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid=getMid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left,right);
    }
    public ListNode merge(ListNode node1,ListNode node2){
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(node1!=null&&node2!=null){
            if(node1.val>node2.val){
                cur.next=node2;
                node2=node2.next;
            }else{
                cur.next=node1;
                node1=node1.next;
            }
            cur=cur.next;
        }
        cur.next=node1==null?node2:node1;
        return dummy.next;
    }
    public ListNode getMid(ListNode node){
        ListNode slow=node;
        ListNode fast=node.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;

    }
}

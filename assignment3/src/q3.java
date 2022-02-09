import java.util.*;
public class q3 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode(-1);
        if(lists==null||lists.length==0){
            return null;
        }
        int interval=1;
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i+=interval*2){
                lists[i]=mergeTwoList(lists[i],lists[i+interval]);
            }
            interval=interval*2;
        }


        return lists[0];

    }
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode newNode=new ListNode(-1);
        ListNode cur=newNode;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
                cur.next=list2;
                list2=list2.next;
            }else{
                cur.next=list1;
                list1=list1.next;
            }
            cur=cur.next;
        }
        while(list1!=null){
            cur.next=list1;
            cur=cur.next;
            list1=list1.next;
        }
        while(list2!=null){
            cur.next=list2;
            cur=cur.next;
            list2=list2.next;
        }
        return newNode.next;
    }
}

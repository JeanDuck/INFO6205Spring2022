public class q2 {
  class  ListNode{
    int val;
    ListNode next;
    public ListNode(int val) { this.val = val; }
  }



    public ListNode getSum(ListNode l1, ListNode l2) {
      //2 4 5
      //5 6 4
      //542+465= 1007
      //7001
      int carry=0;
      ListNode pre = new ListNode(-1);
      ListNode dummyHead = pre;
      while(l1!=null||l2!=null){
        int x = l1==null?0:l1.val;
        int y = l2==null?0:l2.val;
        int sum = x + y + carry;
        if(sum<10){
          carry=0;
        }else{
          carry=sum/10;
          sum=sum%10;
        }
        pre.next=new ListNode(sum);
        pre=pre.next;
        l1=l1==null?null:l1.next;
        l2=l2==null?null:l2.next;
      }
      if(carry==1){
        pre.next=new ListNode(carry);
        pre=pre.next;
      }
      return dummyHead.next;
    }

}

import java.util.*;
public class q9 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            arr.add(node.val);
            node=node.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            int cur=arr.get(i);
            while(!stack.isEmpty()&&arr.get(stack.peek())<cur){
                res[stack.pop()]=cur;
            }
            stack.push(i);
        }
        return res;
    }
}

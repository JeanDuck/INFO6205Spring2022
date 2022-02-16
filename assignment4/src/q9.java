import java.util.*;
public class q9 {
    public class ListNode {
        ListNode next;
        int val;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i: G) set.add(i);
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}

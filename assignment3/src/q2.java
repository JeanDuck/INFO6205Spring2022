import java.util.*;
public class q2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur=head;
        map.put(cur,new Node(cur.val));
        Node temp=map.get(cur);
        while(cur!=null){
            temp.next=getNode(cur.next);
            temp.random=getNode(cur.random);
            temp=temp.next;
            cur=cur.next;
        }
        return map.get(head);


    }
    public Node getNode(Node node){
        if(node!=null){
            if(!map.containsKey(node)){
                map.put(node,new Node(node.val));
            }
            return map.get(node);
        }
        return null;

    }
}

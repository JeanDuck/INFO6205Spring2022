public class q8 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node newNode=new Node(insertVal);
            newNode.next=newNode;
            return newNode;
        }
        Node pre=head;
        Node cur=head.next;
        while(true){
            if(pre.val<cur.val){
                if(insertVal>=pre.val&&insertVal<=cur.val){
                    pre.next=new Node(insertVal,cur);
                    return head;
                }

            }else if(pre.val>cur.val){
                if(pre.val<=insertVal||cur.val>=insertVal){
                    pre.next=new Node(insertVal,cur);
                    return head;
                }

            }
            pre=pre.next;
            cur=cur.next;
            if(pre==head) break;
        }
        pre.next=new Node(insertVal,cur);
        return head;
    }
}

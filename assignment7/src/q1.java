//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class q1 {

  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
 }

    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
      if(node == null) return null;
      Queue<Node> q = new LinkedList<>();
      map.put(node,new Node(node.val,new ArrayList<>()));
      q.add(node);
      while(!q.isEmpty()){
        Node curNode = q.poll();
        List<Node> neighbors = curNode.neighbors;
        for(Node neighbor:neighbors){
          if(!map.containsKey(neighbor)){
            map.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
            q.add(neighbor);
          }
          map.get(curNode).neighbors.add(map.get(neighbor));

        }
      }
      return map.get(node);

    }


}

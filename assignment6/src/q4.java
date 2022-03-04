import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class q4 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    String str = "";
    return inOrder(root,str);
  }
  public String inOrder(TreeNode node,String str){
    if(node==null){
      str += "null,";
    }else{
      str+= str.valueOf(node.val)+",";
      str = inOrder(node.left,str);
      str = inOrder(node.right,str);
    }
    return str;
  }
  public TreeNode rdeserialize(List<String> list) {
    if(list.get(0).equals("null")){
      list.remove(0);
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
    list.remove(0);
    node.left=rdeserialize(list);
    node.right=rdeserialize(list);
    return node;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    List<String> list = new LinkedList<>(Arrays.asList(arr));
    return rdeserialize(list);
  }

}

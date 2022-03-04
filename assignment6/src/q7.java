import java.util.ArrayList;
import java.util.List;
public class q7 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public int sumNumbers(TreeNode root) {
    if(root==null) return 0;
    List<String> listOfInteger = new ArrayList<>();
    int ans = 0;
    findInteger(root,"",listOfInteger);
    for(int i=0;i<listOfInteger.size();i++){
      ans+=Integer.valueOf(listOfInteger.get(i));
    }
    return ans;

  }
  public void findInteger(TreeNode node,String str,List<String> listOfInteger){
    if(node == null) return;
    if(node.left==null && node.right==null){
      str+=node.val;
      listOfInteger.add(str);
      return;
    }
    findInteger(node.left,str+node.val,listOfInteger);
    findInteger(node.right,str+node.val,listOfInteger);

  }

}

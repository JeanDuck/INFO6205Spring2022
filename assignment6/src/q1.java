import java.util.*;
public class q1 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  //map used to record the sum and its frequency
  Map<Integer,Integer> map;
  int res=0;
  public int pathSum(TreeNode root, int targetSum) {
    map = new HashMap<>();
    dfs(root,0,targetSum);
    return res;
  }
  public void dfs(TreeNode node, int curSum, int targetSum){
    if(node==null) return;
    curSum+=node.val;
    if(curSum==targetSum) res++;
    if(map.containsKey(curSum-targetSum)){
      res+=map.get(curSum-targetSum);
    }
    map.put(curSum,map.getOrDefault(curSum,0)+1);
    dfs(node.left,curSum,targetSum);
    dfs(node.right,curSum,targetSum);
    map.put(curSum,map.get(curSum)-1);
  }

}

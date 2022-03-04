

public class q8 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if(root==null) return null;
    root.left = removeLeafNodes(root.left,target);
    root.right = removeLeafNodes(root.right,target);
    if(root.left == null&& root.right == null){
      if(root.val==target){
        root=null;
      }
    }
    return root;
  }

}

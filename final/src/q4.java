public class q4 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
  }
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //binary tree
    //for the binary tree, we can make use of its property node.left.val<node.val<node.right.val
    while(root!=null){
      if(root.val<p.val&&root.val<q.val){
        root=root.right;
      }else if(root.val>p.val&&root.val>q.val){
        root=root.left;
      }else{
        return root;
      }
    }
    return null;

  }

}

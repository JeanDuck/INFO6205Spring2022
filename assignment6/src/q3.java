public class q3 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  int res=0;
  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return res;
  }
  public int dfs(TreeNode root){
    if(root==null) return 0;
    int left = dfs(root.left);
    int right = dfs(root.right);
    int pathLeft=0;
    int pathRight=0;
    if(root.left!=null&&root.val==root.left.val){
      pathLeft=left+1;
    }
    if(root.right!=null&&root.val==root.right.val){
      pathRight=right+1;
    }
    res=Math.max(res, pathRight+ pathLeft);
    return Math.max(pathRight,pathLeft);
  }

}

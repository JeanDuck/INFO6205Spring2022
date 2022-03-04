

public class q6 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  /*get the depth of the tree*/
  public int getDepth(TreeNode node){
    if(node==null) return 0;
    int d=0;
    while(node.left!=null){
      node=node.left;
      d++;
    }
    return d;
  }
  public boolean exists(int idx,int d,TreeNode node){
    int left=0;
    int right=(int)Math.pow(2,d)-1;
    //check the node is in which layer
    for(int i=0;i<d;i++){
      int pivot=left+(right-left)/2;
      //the node i want to find is in the left part
      if(idx<=pivot){
        node=node.left;
        right=pivot;
      }else{
        //the node i want to find is in the right part
        node=node.right;
        left=pivot+1;
      }

    }
    //if node is null, means the node don't exists on idx
    return node!=null;

  }
  public int countNodes(TreeNode root) {
    if(root==null) return 0;
    int d=getDepth(root);
    if(d==0) return 1;
    int left=0;
    int right=(int)Math.pow(2,d)-1;
    while(left<=right){
      int pivot=left+(right-left)/2;
      /*write a function to check whether the node exists at the pivot in last level*/
      //if pivot has a node, i will continue to find in the right part and get the right most node in the last level
      if(exists(pivot,d,root)){
        left=pivot+1;
      }else{
        right=pivot-1;
      }
    }
    // System.out.println(left+" "+right);
    return (int)Math.pow(2,d)-1+left;

  }

}

import java.util.*;
public class q3 {
  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
  }
  int preOrderIdx=0;
  Map<Integer,Integer> inorderMap = new HashMap<>();
  public TreeNode constructTree(int[] preorder, int[] inorder) {
    /*
    preOrder
    center left right
    *[3,9,20,15,7]
    inOrder
    left center right
    * [9,3,15,20,7]
    * */
    for(int i=0;i<inorder.length;i++){
      //store the value and its corresponding index
      inorderMap.put(inorder[i],i);
    }
    TreeNode ans = convertToTree(preorder,0,preorder.length-1);
    return ans;
  }
  public TreeNode convertToTree(int[] preorder,int left,int right){
    if(left>right) return null;
    int nodeVal=preorder[preOrderIdx];
    preOrderIdx++;
    TreeNode newNode = new TreeNode(nodeVal);
    //get current node's left child's index from inorderMap
    newNode.left= convertToTree(preorder,left,inorderMap.get(nodeVal)-1);
    //get current node's right child's index from inorderMap
    newNode.right= convertToTree(preorder,inorderMap.get(nodeVal)+1,right);
    return newNode;
  }
}


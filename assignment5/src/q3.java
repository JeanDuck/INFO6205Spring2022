import java.util.*;
public class q3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Map<Integer,Integer> map = new HashMap<>();;
    int maxWidth=-1;
    public int widthOfBinaryTree(TreeNode root) {
        findMaxWidth(root,0,0);
        return maxWidth;
    }
    public void findMaxWidth(TreeNode node,int curIdx,int level){
        if(node==null) return;
        if(!map.containsKey(level)){
            map.put(level,curIdx);
        }
        maxWidth = Math.max(maxWidth,curIdx-map.get(level)+1);
        findMaxWidth(node.left,2*curIdx,level+1);
        findMaxWidth(node.right,2*curIdx+1,level+1);
    }
}

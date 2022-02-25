import java.util.*;
public class q1 {

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
            stack.push(temp);
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;

    }

}

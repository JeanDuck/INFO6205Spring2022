import java.util.*;
public class q2 {
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
    int maxHeight=0;
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        dfs(root,map);
        for(int i=0;i<=maxHeight;i++){
            List<Integer> temp = map.get(i);
            res.add(temp);
        }
        return res;
    }
    public int dfs(TreeNode root, Map<Integer,List<Integer>> map){
        if(root==null) return -1;
        int left = 1+dfs(root.left,map);
        int right = 1+dfs(root.right,map);
        int level = Math.max(left,right);
        maxHeight = Math.max(maxHeight,level);
        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>());
        }
        map.get(level).add(root.val);
        return level;
    }
}

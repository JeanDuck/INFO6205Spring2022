import java.util.*;

//don't need to copy below code into leetcode
import java.io.Serializable;

/**
 * <p>A convenience class to represent name-value pairs.</p>
 * @since JavaFX 2.0 (javafx.util.Pair;)
 */
class Pair <K,V> implements Serializable {

  /**
   * Key of this <code>Pair</code>.
   */
  private K key;

  /**
   * Gets the key for this pair.
   * @return key for this pair
   */
  public K getKey() { return key; }

  /**
   * Value of this this <code>Pair</code>.
   */
  private V value;

  /**
   * Gets the value for this pair.
   * @return value for this pair
   */
  public V getValue() { return value; }

  /**
   * Creates a new pair
   * @param key The key for this pair
   * @param value The value to use for this pair
   */
  public Pair( K key,  V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * <p><code>String</code> representation of this
   * <code>Pair</code>.</p>
   *
   * <p>The default name/value delimiter '=' is always used.</p>
   *
   *  @return <code>String</code> representation of this <code>Pair</code>
   */
  @Override
  public String toString() {
    return key + "=" + value;
  }

  /**
   * <p>Generate a hash code for this <code>Pair</code>.</p>
   *
   * <p>The hash code is calculated using both the name and
   * the value of the <code>Pair</code>.</p>
   *
   * @return hash code for this <code>Pair</code>
   */
  @Override
  public int hashCode() {
    // name's hashCode is multiplied by an arbitrary prime number (13)
    // in order to make sure there is a difference in the hashCode between
    // these two parameters:
    //  name: a  value: aa
    //  name: aa value: a
    return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
  }

  /**
   * <p>Test this <code>Pair</code> for equality with another
   * <code>Object</code>.</p>
   *
   * <p>If the <code>Object</code> to be tested is not a
   * <code>Pair</code> or is <code>null</code>, then this method
   * returns <code>false</code>.</p>
   *
   * <p>Two <code>Pair</code>s are considered equal if and only if
   * both the names and values are equal.</p>
   *
   * @param o the <code>Object</code> to test for
   * equality with this <code>Pair</code>
   * @return <code>true</code> if the given <code>Object</code> is
   * equal to this <code>Pair</code> else <code>false</code>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Pair) {
      Pair pair = (Pair) o;
      if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
      if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
      return true;
    }
    return false;
  }
}

public class q5 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  //don't need to add this part of code in leetcode



  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> ans=new ArrayList<>();
    int minColumn = 0, maxColumn = 0;
    if(root==null) return ans;
    Queue<Pair<TreeNode,int[]>> q=new LinkedList<>();
    Map<Integer,ArrayList<Pair<Integer,Integer>>> map=new HashMap<>();
    //pair(row,col)
    q.add(new Pair(root,new int[]{0,0}));
    while(!q.isEmpty()){
      Pair<TreeNode,int[]> cur=q.poll();
      TreeNode curNode=cur.getKey();
      int[] arr=cur.getValue();
      int row=arr[0];
      int col=arr[1];
      if(!map.containsKey(col)){
        map.put(col,new ArrayList<Pair<Integer,Integer>>());
      }
      //row & value
      map.get(col).add(new Pair(row,curNode.val));
      minColumn = Math.min(minColumn, col);
      maxColumn = Math.max(maxColumn, col);
      if(curNode.left!=null){
        q.add(new Pair(curNode.left,new int[]{row+1,col-1}));
      }
      if(curNode.right!=null){
        q.add(new Pair(curNode.right,new int[]{row+1,col+1}));
      }
    }
    for(int i = minColumn; i < maxColumn + 1; ++i){
      ArrayList<Pair<Integer,Integer>> list = map.get(i);
      Collections.sort(list,(a,b)->{
        if(a.getKey()==b.getKey()){
          return a.getValue()-b.getValue();
        }else{
          return a.getKey()-b.getKey();
        }

      });
      List<Integer> sortedColumn = new ArrayList();
      for(Pair<Integer,Integer> p:list){
        sortedColumn.add(p.getValue());
      }
      ans.add(sortedColumn);

    }
    return ans;

  }


}

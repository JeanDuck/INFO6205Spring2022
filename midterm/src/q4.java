import java.util.*;
public class q4 {

  public static void main(String[] args) {
    //[[1,3],[2,6],[8,10],[15,18]]
    int[][] intervals = new int[][]{{1,4},{4,5}};
    int[][] res = mergeIntervals(intervals);
    for(int i =0;i<res.length;i++){
      System.out.println(res[i][0]+" "+res[i][1]);
    }

  }
    public static int[][] mergeIntervals(int[][] intervals) {
      //sort array by their start point
      Arrays.sort(intervals,(a,b)->{
        return a[0]-b[0];
      });
      LinkedList<int[]> ans=new LinkedList<>();
      for(int[] interval:intervals){
        if(ans.isEmpty()||ans.getLast()[1]<interval[0]){
          //no overlap
          ans.add(interval);
        }else if(ans.getLast()[1]>=interval[0]){
          //have overlap, merge it
          ans.getLast()[1]=Math.max(ans.getLast()[1],interval[1]);
        }
      }
      //change the list to array
      return ans.toArray(new int[ans.size()][2]);
  }

}

import java.util.*;
public class q7 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        i will compare intervals[i][1] newInterval[0]
        [[1,2],[3,5],[6,7],[8,10],[12,16]]  newInterval = [4,8]
        intervals[i][1]>=newInterval[0], the [Math.min(intervals[i][0],newInterval[0]),Math.max(intervals[i][1],newInterval[1])
        intervals[i][1]<newInterval[0], go to intervals[i+1]
        */
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n&&intervals[i][1]<newInterval[0]){
            ans.add(intervals[i++]);
        }
        while(i<n&&intervals[i][1]>=newInterval[0]){
            if(intervals[i][0]>newInterval[1]) break;
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        //add the remaining
        while(i<n){
            ans.add(intervals[i++]);
        }
        return ans.toArray(new int[ans.size()][]);

    }
}

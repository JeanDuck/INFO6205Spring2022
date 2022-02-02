import java.util.*;
public class q4 {
    public static void main(String[] args) {

    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        q.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur=q.peek();
            if(intervals[i][0]>=cur[1]){
                q.poll();
            }
            q.add(intervals[i]);
        }
        return q.size();
    }
}

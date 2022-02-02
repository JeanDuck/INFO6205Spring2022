import java.util.*;
public class q9 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        int n=firstList.length;
        int m=secondList.length;
        List<int[]> res=new ArrayList<>();
        while(i<n&&j<m){
            int newStart=Math.max(firstList[i][0],secondList[j][0]);
            int newEnd=Math.min(firstList[i][1],secondList[j][1]);
            if(newStart<=newEnd){
                res.add(new int[]{newStart,newEnd});
            }
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}

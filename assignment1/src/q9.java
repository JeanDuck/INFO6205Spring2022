import java.util.*;
public class q9 {
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<Map.Entry<Integer,Integer>> temp=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(temp,(a,b)->{
            if(a.getValue()==b.getValue()){
                return b.getKey()-a.getKey();
            }
            return a.getValue()-b.getValue();
        });
        int[] ans=new int[nums.length];
        int g=0;
        for(int i=0;i<temp.size();i++){
            Map.Entry<Integer,Integer> cur=temp.get(i);
            int key=cur.getKey();
            int v=cur.getValue();
            for(int x=0;x<v;x++){
                ans[g++]=key;
            }
        }
        return ans;
    }
}


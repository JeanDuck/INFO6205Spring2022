import java.util.*;
public class q10 {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> q = new PriorityQueue<>((a,b)->{
            if(map.get(a)==map.get(b)){
                return b.compareTo(a);
            }else{
                return map.get(a)-map.get(b);
            }

        });
        List<String> ans = new ArrayList<>();
        for(String key:map.keySet()){
            q.add(key);
            if(q.size()>k){
                q.poll();
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}

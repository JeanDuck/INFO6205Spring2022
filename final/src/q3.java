import java.util.*;
public class q3 {

  public static void main(String[] args) {
//      String[] test= {"eat","tea","tan","ate","nat","bat"};
//      String[] test= {""};
//      String[] test= {"a"};
    String[] test = {};

    List<List<String>> res = groupAnagrams(test);
    for(int i=0;i<res.size();i++){
      List<String> temp = res.get(i);
      for(int j=0;j<temp.size();j++){
        String cur = temp.get(j);
        System.out.print(cur);
        System.out.print(" ");
      }
      System.out.println(" ");
    }

  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    //use map to record the string which are in the same group
    List<List<String>> ans = new ArrayList<>();
    if(strs==null||strs.length==0){
      return ans;
    }

    Map<String,List<String>> map = new HashMap<>();
    for(String str:strs){
      char[] cur=str.toCharArray();
      //for example, after sorting, eat and tea are in the same group
      Arrays.sort(cur);
      //if map doesn't contain current string, it means we haven't built a group for this string before
      if(!map.containsKey(String.valueOf(cur))){
        map.put(String.valueOf(cur),new ArrayList<>());
      }
      map.get(String.valueOf(cur)).add(str);
    }
    //map's value is what we need
    for(List<String> val:map.values()){
      ans.add(val);
    }
    return ans;

  }

}

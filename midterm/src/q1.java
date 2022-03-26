import java.util.*;

public class q1 {

  public static void main(String[] args) {
    //new int[]{0,1,3,50,75}
    int[] nums = new int[]{-1};
    //0 99
    List<String> res = getMissing(nums,-1,-1);
    for(int i =0 ;i<res.size();i++){
      System.out.println(res.get(i));
    }
  }

    public static List<String> getMissing(int[] nums, int lower, int upper) {
        /*
        1. the nums is in a sorted order, so the first thing is that i should be careful about its boundary, figure out whether the left boundary is larger than the lower or not, and whether the right boundary is larger than the upper or not. the same for upper
        2. i can add a format function, if a==b ,return "a" else return "a->b"
        */
      List<String> ans=new ArrayList<>();
      int n=nums.length-1;
      String temp="";
      if(nums.length==0||nums==null){
        temp=format(lower,upper);
        ans.add(temp);
        return ans;
      }
      if(nums[0]>lower){
        temp=format(lower,nums[0]-1);
        ans.add(temp);
      }
      for(int i=0;i<n;i++){
        if((nums[i]+1)!=nums[i+1]){
          String cur=format(nums[i]+1,nums[i+1]-1);
          ans.add(cur);
        }
      }

      if(nums[n]<upper){
        temp=format(nums[n]+1,upper);
        ans.add(temp);
      }
      return ans;
    }
    public static String format(int a, int b){
      if(a==b){
        return String.valueOf(a);
      }else{
        return a+"->"+b;
      }
    }

}


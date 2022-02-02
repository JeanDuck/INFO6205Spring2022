import java.util.*;
public class q6 {
    public static int threeSumClosest(int[] nums, int target) {
        /*
         1. sort the nums first
         2. use three pointer
        */
        Arrays.sort(nums);
        //diff==0，target is equal to sum
        int diff=Integer.MAX_VALUE;
        int res=0;
        int n=nums.length;
        for(int i=0;i<n&&diff!=0;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<diff){
                    res=sum;
                    diff=Math.abs(sum-target);
                }
                //try to make the sum to be closer to the target
                if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }

        }
        return res;

    }
}

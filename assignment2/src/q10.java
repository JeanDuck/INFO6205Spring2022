import java.util.*;
public class q10 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,target,0,4);


    }
    public List<List<Integer>> kSum(int[] nums, int target,int index,int kSum){
        List<List<Integer>> res = new LinkedList<>();
        if(index==nums.length){
            return res;
        }
        if(kSum==2){
            int left=index;
            int right=nums.length-1;

            while(left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> temp=new LinkedList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }
            }

        }else{
            //make sure there is enough elements remaining to be selected
            for(int i=index;i<nums.length-kSum+1;i++){
                //k sum changes to k-1 sum
                List<List<Integer>> temp=kSum(nums,target-nums[i],i+1,kSum-1);
                for(List<Integer> c:temp){
                    c.add(0,nums[i]);
                }
                res.addAll(temp);
                while(i+1<nums.length&&nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return res;

    }
}

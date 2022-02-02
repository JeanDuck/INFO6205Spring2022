public class q2 {
    public static void main(String[] args) {

    }
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length-1;
        int left = 0;
        int right = n;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else if(nums[mid]==nums[mid+1]){
                if((mid-left)%2!=0){
                    right=mid-1;
                }else{
                    left=mid+2;
                }
            }else if(nums[mid]==nums[mid-1]){
                if((mid-1-left)%2!=0){
                    right=mid-2;
                }else{
                    left=mid+1;
                }

            }
        }
        return nums[left];

    }
}

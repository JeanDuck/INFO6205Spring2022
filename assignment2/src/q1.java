public class q1 {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        /*
        clarify:
        1. sorted array?
        2. distince integers?
        use binary search:
        left=0;
        right=nums.length-1;
        mid
        1. nums[mid]==target return mid;
        2. nums[mid]<target{target<=nums[mid+1]; return mid+1;}{ left=mid+1}
        3. nums[mid]>target{target<=nums[mid-1] return mid-1;}{right=mid-1}

        left==right
        nums[left]>target?  left==0?0:left-1
        nums[left]<target?  left+1
        */
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
        }
        if(nums[left]>=target){
            return left;
        }else{
            return left+1;
        }
    }
}

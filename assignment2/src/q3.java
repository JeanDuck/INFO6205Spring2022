public class q3 {
    public static void main(String[] args) {

    }
    public static int findMin(int[] nums) {
        /*
        clarify:
        is the num only contains unique integer
        */
        int n=nums.length-1;
        int left=0;
        int right=n;
        if (nums[right] > nums[0]){
            return nums[0];
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(mid>0&&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>nums[left]&&nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return nums[left];

    }
}

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        int[] nums1=new int[]{2,0,2,1,1,0};
        int[] nums2=new int[]{2,0,1};
        sortColors(nums1);
        sortColors(nums2);
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
        System.out.println("-------------");
        for(int j=0;j<nums2.length;j++){
            System.out.println(nums2[j]);
        }
    }
    public static void sortColors(int[] nums) {
        //p0 is used to record the rightmost boundary of 0,
        //p1 is used to record the leftmost boundary of 1
        int p0=0;
        int p1=nums.length-1;
        int cur=0;
        while(cur<=p1){
            if(nums[cur]==0){
                swap(cur,p0,nums);
                cur++;
                p0++;
            }else if(nums[cur]==2){
                swap(cur,p1,nums);
                p1--;
            }else{
                cur++;
            }
        }

    }
    public static void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}

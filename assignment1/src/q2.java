import java.util.*;
public class q2 {
    public static void main(String[] args) {
        int[] nums1=new int[]{3,2,3};
        int[] nums2=new int[]{1};
        List<Integer> l1 = majorityElement(nums1);
        List<Integer> l2 = majorityElement(nums2);
        for(int i=0;i<l1.size();i++){
            System.out.println(l1.get(i));
        }
        System.out.println("-------------");
        for(int j=0;j<l2.size();j++){
            System.out.println(l2.get(j));
        }
    }
    public static List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int cnt1=0;
        int cnt2=0;
        Integer can1=null;
        Integer can2=null;
        List<Integer> ans = new ArrayList<>();
        for(int num:nums){
            if(can1!=null&&can1==num){
                cnt1++;
            }else if(can2!=null&&can2==num){
                cnt2++;
            }else if(cnt1==0){
                can1=num;
                cnt1++;
            }else if(cnt2==0){
                can2=num;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int x:nums){
            if(can1!=null&&x==can1){
                cnt1++;
            }
            if(can2!=null&&x==can2){
                cnt2++;
            }
        }
        if(cnt1>n/3){
            ans.add(can1);
        }
        if(cnt2>n/3){
            ans.add(can2);
        }

        return ans;

    }
}

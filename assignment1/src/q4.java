import java.util.*;
public class q4 {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        List<Integer> res=new ArrayList<>();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
                while(i<nums1.length&&nums1[i]==nums1[i-1]) i++;
                while(j<nums2.length&&nums2[j]==nums2[j-1]) j++;
                continue;
            }else if(nums1[i]<nums2[j]){
                i++;
                while(i<nums1.length&&nums1[i]==nums1[i-1]) i++;
            }else{
                j++;
                while(j<nums2.length&&nums2[j]==nums2[j-1]) j++;
            }


        }
        int[] ans=new int[res.size()];;
        for(int k=0;k<res.size();k++){
            ans[k]=res.get(k);
        }
        return ans;

    }
}

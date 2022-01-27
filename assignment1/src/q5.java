import java.util.*;
public class q5 {
    public static void main(String[] args) {

    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int left=0;
        int right=n-k;
        while(left<right){
            int mid=left+(right-left)/2;
            //arr[mid]<x<arr[mid+k]
            if(arr[mid]==arr[mid+k]){
                if(x>arr[mid]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }else if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){
                left=mid+1;

            }else{
                right=mid;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<left+k;i++){
            ans.add(arr[i]);
        }
        return ans;

    }
}

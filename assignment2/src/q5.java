import java.util.*;
public class q5 {
    Map<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] unique=new int[map.size()];
        int i=0;
        for(int key:map.keySet()){
            unique[i++]=key;
        }
        int n=unique.length-1;
        if(n<k){
            return unique;
        }
        quickselect(0,n,unique,n-k);
        int[] res=new int[k];
        for(int j=0;j<k;j++){
            res[j]=unique[n-k+j+1];
        }
        return res;
    }
    public void quickselect(int low,int high,int[] num,int ks){
        if(low==high) return;
        Random rand=new Random();
        int pivot_idx=low+rand.nextInt(high-low);
        swap(low,pivot_idx,num);
        int pivot=low;
        int temp=num[pivot];
        int i=low;
        int j=high;
        while(i<j){
            while(i<j&&map.get(num[j])>=map.get(temp)) j--;
            while(i<j&&map.get(num[i])<=map.get(temp)) i++;
            if(i<j){
                swap(i,j,num);
            }
        }
        swap(i,pivot,num);
        pivot=i;
        if(pivot==ks){
            return;
        }else if(pivot>ks){
            quickselect(low,pivot-1,num,ks);
        } else{
            quickselect(pivot+1,high,num,ks);
        }

    }
    public void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

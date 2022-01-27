import java.util.List;

public class q3 {
    public static void main(String[] args) {
        int[] nums1=new int[]{3,0,6,1,5};
        int[] nums2=new int[]{1,3,1};
        int l1 = hIndex(nums1);
        int l2 = hIndex(nums2);
        System.out.println(l1);
        System.out.println("-------------");
        System.out.println(l2);

    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c: citations)
            papers[Math.min(n, c)]++;
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }

}

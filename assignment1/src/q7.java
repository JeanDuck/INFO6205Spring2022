public class q7 {
    public static void main(String[] args) {

    }
    public static String customSortString(String order, String s) {
        int[] cnt=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            cnt[ch-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char ch=order.charAt(i);
            for(int k=0;k<cnt[ch-'a'];k++){
                ans.append(ch);
            }
            cnt[ch-'a']=0;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j< cnt[i];j++){
                ans.append((char)(i+'a'));
            }

        }
        return ans.toString();

    }
}

public class q6 {
    public static void main(String[] args) {

    }
    public static String reorganizeString(String s) {
        int[] letter=new int[26];
        int max=-1;
        char maxLetter=' ';
        for(char ch:s.toCharArray()){
            letter[ch-'a']++;
            if(max<letter[ch-'a']){
                max=letter[ch-'a'];
                maxLetter=ch;
            }
        }
        if(max>(s.length()+1)/2) return "";
        char[] res=new char[s.length()];
        int idx=0;
        while(max>0){
            res[idx]=maxLetter;
            idx+=2;
            letter[maxLetter-'a']--;
            max--;
        }
        for(int i=0;i<letter.length;i++){
            while(letter[i]>0){
                if(idx>=s.length()){
                    idx=1;
                }
                res[idx]=(char)(i+'a');
                idx+=2;
                letter[i]--;
            }
        }
        return String.valueOf(res);

    }
}

public class q1 {

  public static void main(String[] args) {
    String test1 = "aabcccccaaa";
    String res1= compressString(test1);

    String test2 = "ab";
    String res2= compressString(test2);

    //If the "compressed" string would not become smaller than the original string,
    // your method should return the original string
    String test3 = "ABBaa";
    String res3= compressString(test3);

    String test4 = "ABBaaaa";
    String res4= compressString(test4);


    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
    System.out.println(res4);

  }

  public static String compressString(String str) {
    // write your code here
    if(str==null||str.length()==0){
      return "";
    }
    //transform string str to array
    char[] strToChars = str.toCharArray();
    //mark the first character
    char lastChar = str.charAt(0);
    int count = 0;

    StringBuffer res = new StringBuffer();
    for(char c:strToChars){
      if(lastChar == c){
        //if current character equals to the previous character, then increase the count of current character
        count++;
      }else{
        //append current character and its count to res string
        res.append(lastChar).append(count);
        //update last character and its count
        lastChar=c;
        count=1;
      }
    }
    res.append(lastChar).append(count);
    if(res.length()<str.length()){
      return res.toString();
    }
    return str;
  }
}




















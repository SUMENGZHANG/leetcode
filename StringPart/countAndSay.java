/**
 * leetcode 38
 */
public class countAndSay {

    /**
     * 暴力法
     */
    public static  String countAndSay(int n) {
        String res = "1";
        if(n==1) return res;
        for(int i = 2;i<=n;i++){
            res = countAd(res);

        }

        return res;
        

    }
    /**
     * 数连续数字的个数 拼接成字符串返回
     */
    public static String count(char []arr){
        String res = "";
        int indexOne = 0;
        int indexTwo = 1;
        int count = 0;
        while(indexOne<arr.length){
            
            if(indexTwo<arr.length&&arr[indexOne]==arr[indexTwo]){
                indexTwo++;
                count++;

            }else{
                    if(count==0){
                        int cur = arr[indexOne]-'0';
                        res = res+1;
                        res = res+cur;
                        indexOne++;

                    }else{
                        count = count+1;
                        res = res + count;
                        int  curVal = arr[indexOne]-'0';
                        res = res+curVal;
                        indexOne = indexTwo;
                        count = 0;
                    }
                    indexTwo = indexOne+1;
                    
            }
        }
        return res;
    }

    /**
     * 数连续的个数  双指针 优美版本
     */
    public static String countAd(String s){
        StringBuffer res = new StringBuffer();
        int indexOne = 0;
        int indexTwo = 0;
        int len = s.length();
        while(indexTwo<len){
            while(indexTwo<len&&s.charAt(indexOne)==s.charAt(indexTwo)){
                indexTwo++;
            }
            res = res.append(Integer.toString(indexTwo-indexOne)).append(s.charAt(indexOne));
            indexOne = indexTwo;

        }
        return res.toString();

    }



    /**
     *  递归
     */
    public static  String countAndSayAd(int n) {
        if(n==1) return "1";
        String res = countAndSayAd(n-1);
        return countAd(res);
    }




    public static void main(String[] args) {
       int n =5;
       char []arr = {1};
      // System.out.println(countAd("12"));
       System.out.println(countAndSay(n));
        
    }

    
}

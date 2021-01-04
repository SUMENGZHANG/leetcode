/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class IsPalindrome {
    /**
     * 1. 双指针
     * 2. 怎么解决符号问题，我只需要数字和字母
     */
    public static  boolean isPalindrome(String s) {

        char []arr = s.toCharArray();
        int indexOne = 0;
        int indexTwo = arr.length-1;
        while(indexOne<indexTwo){
            while(indexOne<indexTwo&&!isValidChar(arr[indexOne])){
                indexOne++;
               
            }
            while(indexOne<indexTwo&&!isValidChar(arr[indexTwo])){
                indexTwo--;
               
            }
            // int valOne  = Integer.valueOf(arr[indexOne]);
            // int valTwo = Integer.valueOf(arr[indexTwo]);
            // int dis = Math.abs(valOne-valTwo);
            // if(dis==0||dis==32){       错误的判别方式
            //     indexOne++;
            //     indexTwo--;
            // }else return false;
            if(Character.toLowerCase(arr[indexOne])!=Character.toLowerCase(arr[indexTwo])){
                return false;

            }
            indexOne++;
            indexTwo--;
        
        }

        return true; 

    }
    public static boolean isValidChar(char ch){
        int value = Integer.valueOf(ch);
        if((value>=48&&value<=57)||(value>=65&&value<=90)||(value>=97&&value<=122)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s =  ".,";
        System.out.println(isPalindrome(s));


    }
    
}

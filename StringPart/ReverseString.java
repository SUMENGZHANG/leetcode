/**
 *  leetcode 344
 */
public class ReverseString {
    
    /**
      *  我的第一思路：双指针
         时间复杂度：O(n/2) 

     */
    public static void reverseString(char[] s) {
        int indexOne = 0;;
        int indexTwo = s.length-1;;
        while(indexOne<indexTwo){
                char curChar = s[indexOne];
                s[indexOne] = s[indexTwo];
                s[indexTwo] = curChar;
                indexOne++;
                indexTwo--;
        }


    }
    public static void main(String[] args) {
        char [] s = {'h','e','l','l','o'};
        reverseString(s);
        for (char char1 : s) {
            System.out.println(char1);
        }
    }
}

/**
 *  剑指offer 50 
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        
        int []arr = new int[26];
        for(int i = 0;i<s.length();i++){
            arr[s.charAt(i)-'a'] = arr[s.charAt(i)-'a'] +1;
        }
        for(int i = 0;i<s.length();i++){
           if(arr[s.charAt(i)-'a']==1){
               return s.charAt(i);
           }
        }
        return ' ';

    }
}

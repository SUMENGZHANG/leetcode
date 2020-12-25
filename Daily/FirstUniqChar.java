
import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class FirstUniqChar {
    /**
     * 俺用一个map先存数量
     */
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char []arr = s.toCharArray();
        // 遍历一遍
        for (char c : arr) {
            if(map.containsKey(c)){
                int num = map.get(c);
                map.put(c, ++num);
            }else{
                map.put(c, 1);
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(map.get(arr[i])==1){
                return i;
            }
        }
    
    return -1;

    }

    /**
     *  因为只有小写字母，所以可以通过一个大小为26的数组来存储每个字母出现的次叔
     *  效率比用hashmap快
     * @param s
     * @return
     */
    public int firstUniqCharWithArray(String s){
        int []res = new int[26];
        for(int i = 0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(res[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
    
}

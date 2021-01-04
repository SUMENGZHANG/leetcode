import java.util.*;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */

public class IsAnagram {
    // 统计总长度 和  每个字母出现的长度
    public static boolean isAnagram(String s, String t) {
           if(s.length()!=t.length()) return false;
            
           int []arrS = new int[26];
           int []arrT = new int[26];
           for(int i = 0;i<s.length();i++){
               arrS[s.charAt(i)-'a'] = arrS[s.charAt(i)-'a']+1;
               arrT[t.charAt(i)-'a'] = arrT[t.charAt(i)-'a']+1;
           }
           for(int i = 0;i<arrS.length;i++){
               if(arrS[i]!=arrT[i]) return false;
           }
           return true;

        
    }

    public static boolean isAna(String s,String t){
        if(s.length()!=t.length()) return false;
        // 两个数组数据  
        Map<Character,Integer> mapOne = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            mapOne.put(s.charAt(i), mapOne.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0;i<t.length();i++){
            mapOne.put(t.charAt(i), mapOne.getOrDefault(t.charAt(i),0)-1);
        }

        for (int value : mapOne.values()) {
            if(value!=0) return false;
            
        }
        
        return true;
    }

    public static boolean isAnaWithSort(String s,String t){
        char []sArr = s.toCharArray();
        char []tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        
        String newS = String.valueOf(sArr);
        String newT = String.valueOf(tArr);
        return  newS.equals(newT);
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnaWithSort(s, t));
    }
    
}

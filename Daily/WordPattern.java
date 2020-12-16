/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> resMap = new HashMap<>();
        String []str = s.split(" ");
        char []patternArr = pattern.toCharArray();
        if(str.length!=patternArr.length){
            return false;
        }
        for(int i = 0;i<str.length;i++){
            // 如果有这个key
            if(resMap.containsKey(patternArr[i])){
                String curStr = resMap.get(patternArr[i]);
                if(!curStr.equals(str[i])){
                    return false;
                }

            }else{
                // 没有key但是有这个value
                if(resMap.containsValue(str[i])){
                    return false;
                }
                resMap.put(patternArr[i], str[i]);
            }

        }
        
        /*  大意了我忘了 map有contains values
        // 该方法无法避免 a 和 c都对应着一个值
        Set<String> set = new HashSet<>();
        for(String value:resMap.values()){
            set.add(value);
        }

        if(set.size()!=resMap.size()){
            return false;
        }*/
        return true;
    }

    public static void main(String[] args) {
        System.err.println(wordPattern("abbbc", "cat dog dog dog money"));
        
    }
}

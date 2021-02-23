import java.util.*;
public class LengthOfLongestSubString {
    public static int lengthOfLongestSubString(String s){
        if(s.length()==0) return 0;
        int maxLen = 0;
        // 双指针移动 加上set判断是否已经包含某个数字
        Map<Character,Integer> hashMap = new HashMap<>();
        int left = 0;

        for(int right = 0;right<s.length(); right++){
            if(hashMap.containsKey(s.charAt(right))&&hashMap.get(s.charAt(right))>=left){
               // maxLen = Math.max(maxLen,right-left);
                left = hashMap.get(s.charAt(right))+1;
                
                //hashMap.put(s.charAt(right),right);
                // 需要去掉这个点之前的一些数据 更新hashMap
                
            }//else{
                hashMap.put(s.charAt(right),right);
               // maxLen = Math.max(maxLen,right-left+1);
            //}
            maxLen = Math.max(maxLen,right-left+1);
            
        }

        return maxLen;


    }

    /**
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSimple(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                left = Math.max(left,map.get(s.charAt(i)) + 1);       //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
            }        //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
            map.put(s.charAt(i),i);      //再更新map中a映射的下标
            max = Math.max(max,i-left+1);     //比较两个参数的大小
        }
        return max;
        
    }

    
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));

    }
}
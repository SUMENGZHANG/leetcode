/**
 *  定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs){
        // 创建返回集
        List<List<String>> res = new ArrayList<>();
        // 存储不同类型的list的映射关系
        Map<String,List<String>> map = new HashMap<String,List<String>>();


        // 得到每一个字符串，将字符排序 然后判断是否想等
       for (String str : strs) {
         // 保存下当前的值
          String curStr =str;

         char []curArr = str.toCharArray();
         // 可以通过自己自己的排序算法实现,先使用官方的
         Arrays.sort(curArr);
         // 换成字符串信息
          String key = String.copyValueOf(curArr);
        /*  结构一可以实现但是不够精简
         // 如果已经有这个Key
         if(map.containsKey(key)){
           List<String> list = map.get(key);
           list.add(curStr);
           map.put(key, list);
         }else{
           // 如果没有这个key
           List<String> list = new ArrayList<>();
           list.add(curStr);
           map.put(key, list);
         }*/
         // 改造代码，参考leetcode题解
        List<String> list =  map.getOrDefault(key, new ArrayList<String>());
        list.add(curStr);
        map.put(key, list);
       }
       /*
       // 将map存储的放入list
       Iterator iter = map.entrySet().iterator();
       while(iter.hasNext()){
         Entry<String,List<String>> e = (Entry<String,List<String>>)iter.next();
         List<String> curList = e.getValue();
         res.add(curList);
       }*/
       res = new ArrayList<>(map.values());
       return res;


    }
    public static void main(String[] args) {
      String []arr = {"eat","tea","tan","ate","nat","bat"};
      System.out.println(groupAnagrams(arr));


      
    }
}
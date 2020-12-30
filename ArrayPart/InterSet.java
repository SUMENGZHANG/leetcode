import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

 

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class InterSet {
    /**
     *  无序的
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 存储到hashmap中
        Map<Integer,Integer> res1 = getHashMap(nums1);
        Map<Integer,Integer> res2 = getHashMap(nums2);
        List<Integer> resList = new ArrayList<>();

        for(int curKey:res1.keySet()){
            if(res2.containsKey(curKey)){
                // 以小的数量的为准
                int num = res2.get(curKey)<res1.get(curKey)?res2.get(curKey):res1.get(curKey);
                for(int i = 0;i<num;i++){
                    resList.add(curKey);
                }
                
            }
        }
        return resList.stream().mapToInt(Integer::valueOf).toArray();
       
      
    }
    public static Map<Integer,Integer> getHashMap(int []nums){
        Map<Integer,Integer> res = new HashMap<>();
        for (int i : nums) {
            res.put(i, res.getOrDefault(i, 0)+1);
        }
        return res;

    }

    /**
     * 通过排序,比刚刚快. 最好使用array存储，使用list再换成array会影响速度。
     */
    public static int[] intersectWithSort(int[] nums1, int[] nums2) {
            //List<Integer> resList = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int indexOne = 0;
            int indexTwo = 0;
            int []res = new int[Math.min(nums1.length,nums2.length)];
            int index = 0;
            while(indexOne<nums1.length&&indexTwo<nums2.length){
                if(nums1[indexOne]==nums2[indexTwo]){
                    //resList.add(nums1[indexOne]);
                    res[index++] = nums1[indexOne];
                    indexOne++;
                    indexTwo++;
                }else if(nums1[indexOne]<nums2[indexTwo]){
                    indexOne++;
                }else{
                    indexTwo++;
                }
            }
            return  Arrays.copyOfRange(res, 0,index);
        

    }
    public static void main(String[] args) {
        int []nums1 = {4,9,5};
        int []nums2 = {9,4,9,8,4};
        int []res = intersectWithSort(nums1, nums2);
        for (int i : res) {
            System.out.println(i);
        }
        
        
    }
    
}

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        int max = 0;
        // 求出最大的频率的数据存入map
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            int num = 0;
            if(map.containsKey(i)){
                num = map.get(i);
                map.put(i, ++num);
            }else{
                map.put(i, 1);
                 
            } 
        }
        for (int i:map.values()) {
            max = Math.max(max,i);
            
        }
        
         int minVal = Integer.MAX_VALUE;
        // 如果这数据频率值为最大值
        for(int i = 0;i<nums.length;i++){
            // 如果
            if(map.get(nums[i])==max){
                minVal = Math.min(minVal,queryDistance(nums, nums[i]));
            }
        }

       return minVal;
        
=======
    public int findShortestSubArray(int[] nums) {
        return 0;
>>>>>>> 2b44e24a40e8b6b2f7dcdaaff146b2e4e898a2aa

    }
     // 找到第一个max 和最后一个max返回长度
     public static int queryDistance(int []status,int val){
    
        int left = 0;
        int right = status.length-1;
        while(true){
            if(status[left]==val){
                break;
            }
            left++;
        }
        while(true){
            if(status[right]==val){
                break;
            }
            right--;
        }
        return right-left+1;
      

    }

    /**
     * 力扣解决方法
     * @param nums
     * @return
     */
    public static int findShortestSubArrayAD(int []nums){
        Map<Integer,Integer> leftMap = new HashMap<>(),
        rightMap = new HashMap<>(), maxMap = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            if(!leftMap.containsKey(nums[i])){
                leftMap.put(nums[i], i);
            }
                rightMap.put(nums[i],i);
            
            maxMap.put(nums[i], maxMap.getOrDefault(nums[i], 0)+1);

        }
        
        int min = nums.length;
        int max = Collections.max(maxMap.values());
        for (int i : maxMap.keySet()){
            if(maxMap.get(i)==max){
                min = Math.min(min,rightMap.get(i)-leftMap.get(i)+1);
            }
  
        }
        return min;


    }
    public static void main(String[] args) {
        int[] nums = { 1};
        System.out.println(findShortestSubArrayAD(nums));
    }

}

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
    /**
     *  简单版本
     * @param nums
     * @return
     */
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
     * 
     * @param nums
     * @return
     */
    public int findShortestSubArraySimple(int[] nums){
        // 这个数组结构是 {数量，初始位置，最后的位置}
        Map<Integer,int[]> map = new HashMap<Integer,int[]>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] arr = entry.getValue();
            if(maxNum<arr[0]){
                maxNum = arr[0];
                minLen = arr[2]-arr[1]+1;
            }else if(maxNum==arr[0]){
                if(minLen>arr[2]-arr[1]+1){
                    minLen = arr[2]-arr[1]+1;
                }
            }
        }
        return minLen;


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

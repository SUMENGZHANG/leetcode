/**
 * leetcode 1438
 */
import java.util.*;
public class LongestSubArray {
    /**
     *  暴力法
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubArray(int[] nums, int limit){
        if(nums.length < 2) return 1;
        // 滑动窗口， 用一个max min 维护 这个 子数组里面的最大值和最小值
        int max  = nums[0];
        int min = nums[0];
        int left = 0;
        int maxLen = 0;
        for(int right = 1;right<nums.length;right++){
            max = Math.max(max,nums[right]);
            min = Math.min(min,nums[right]);
            while(max-min>limit){
                
                    int[] res = getMin(nums,++left,right);
                
                    min = res[0];
                    max = res[1];
              
            }
            maxLen = Math.max(maxLen,right-left+1);


        }
        return maxLen;

    }
    public static int[] getMin(int[] nums, int left, int right){
        int []res = new int[2];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = left;i<=right;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        res[0] = min;
        res[1] = max;
        return res;


    }

    /**
     *  使用treemap解决此类问题
     */
    public int longestSubArrayWithTreeMap(int[] nums, int limit){
        if(nums.length<2) return 1;
        //暴力法使用的 遍历寻找， 可以才用treemap来维护
        int left = 0;
        int len = nums.length;
        int max = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int right = 0;right<len;right++){
            map.put(nums[right],map.getOrDefault(nums[right], 0)+1);
            while(map.lastKey()-map.firstKey()>limit){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                    
                }
                left++;
            }
            max = Math.max(max,right-left+1);
            
        }
        return max;

    }


        


    
    
}

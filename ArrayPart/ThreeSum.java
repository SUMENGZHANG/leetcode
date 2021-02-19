import java.util.ArrayList;

/**
 * 三数之和
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<=2) return res;
        int len = nums.length;
        // 先排序数组
        Arrays.sort(nums);
        // 先固定一个点
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            // 找到两个值等于target
            int target = -nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    // 继续消除相同数据
                    while(left<right&&nums[left]==nums[left-1]) left++;
                    while(left<right&&nums[right]==nums[right+1]) right--;

                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }

            }
        }
        return res;
        

    }
    
}

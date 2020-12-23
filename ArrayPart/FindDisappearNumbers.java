import java.util.*;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDisappearNumbers {
    /**
     * 可以实现，但是复杂度不是O(n)
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        // sort the numbers
        Arrays.sort(nums);
        // how many duplicate numbers we have 
        int dupNum = 0;
        int len = nums.length;
        int midNum = 0;
        // for loop to find the same numbers
        for (int i = 1;i<len;i++){
            if(nums[i]==nums[i-1]){
                dupNum++;
            }else if(nums[i]>nums[i-1]+1){
                //不满足o(n)但是先 试下
                for(int j = 1;j<nums[i]-nums[i-1];j++){
                    res.add(nums[i-1]+j);
                    midNum++;

                }
            
            }
        }
        if(midNum<dupNum){
            // 存在最左边和最右边的问题
            if(nums[nums.length-1]<len){
                for(int j = 1;j<=len-nums[nums.length-1];j++){
                    res.add(nums[nums.length-1]+j);
                }
            }
            if(nums[0]>1){
                for(int j = 1;j<=nums[0]-1;j++){
                    res.add(nums[0]-j);
                }
            }


        }
        return res;
        


    }


    /**
     *  力扣大佬解法 
     *  1. 给每个下表做上记号
     */
    public static List<Integer> findDisappearNumbersAD(int []nums){
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            int index = num-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }
        }
        for(int j = 0;j<nums.length;j++){
            if(nums[j]>0){
                res.add(j+1);
            }
        }

        
        return res;
    

    }
    public static void main(String[] args) {
        int []nums = {1,1,2,2};
        System.out.println(findDisappearNumbersAD(nums));
        
    }
    
}

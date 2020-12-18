/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes {


    /**
     *  双指针记录位置
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int flag = 0;
        int flagLast = 0;
        int max = 0;
        for(int i = flag;i<nums.length;i++){
            // 如果
            if(nums[i]==0){
                max = Math.max(max, flagLast-flag);
                flag = i+1;
                flagLast = i+1;

            }else{
                flagLast++;
            }

        }
        
        return Math.max(max, flagLast-flag);

    }

    public static int findMaxConsecutiveSimple(int []nums){
        int max = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                max = Math.max(max, count);
                count = 0;
            }

            
        }
        return Math.max(max, count);

    }
    public static void main(String[] args) {
        int []nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveSimple(nums));
    }
    
}

/** 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Rotate {
    /**
     * 暴力法
     * @param nums
     * @param k
     */
    public static  void rotate(int[] nums, int k) {
        // 如果查过了数组长度，则取余
        k = k%nums.length;
        // 每次移动一个位置
        for(int i = 0;i<k;i++){
            int cur = nums[nums.length-1];
            for(int j = 0;j<nums.length;j++){
                int nowVal = nums[j];
                nums[j] = cur;
                cur =  nowVal;
            }
        }
    }

    /**
     * 旋转数组
     */
    public static  void rotateWithReverse(int[] nums, int k) {
         
         k = k%nums.length;
         // 反转所有的数  1234567 -》 7654321
         reverse(nums, 0, nums.length-1);

         //  反转前 k个数 
         reverse(nums, 0, k-1);

         // 反转后  len-k反转
         reverse(nums, k, nums.length-1);


       
    }
    public static void reverse(int []nums,int start,int end){
        while(start<end){
            int curVal = nums[start];
            nums[start] = nums[end];
            nums[end] = curVal;
            start++;
            end--;
        }
        

    }
    /**
     *  环状数组
     */
    public static void circle(int []nums){
        // just empty

    }

    public static void main(String[] args) {
        int []nums = {-1};
        int k = 2;
        rotateWithReverse(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }



    }
    
}

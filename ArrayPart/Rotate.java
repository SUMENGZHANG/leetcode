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
     *  
     */
    public static void circle(int []nums,int k){
         int len = nums.length;
         k = k%len;
         int count = gcd(k, len);
         for(int i = 0;i<count;i++){
             int curVal = nums[i];
             int index = i;
             do{
                 // i 和  i+K%len换
                int nextIndex = (index+k)%len;
                int nextVal =  nums[nextIndex];
                nums[nextIndex] = curVal;
                curVal = nextVal;
                index = nextIndex;
             }while(index!=i);
         }

        

    }

    /**
     * 最大公约数
     */
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 3;
      
        circle(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }



    }
    
}

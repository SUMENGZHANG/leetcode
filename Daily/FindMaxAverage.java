class FindMaxAverage{
    public static double findMaxAverage(int[] nums,int k){
        int max = Integer.MIN_VALUE;
        int len  = nums.length;
        int left = 0;
        int right = k-1;
        while(right<len){
            int count = 0;
            for(int i = left;i<=right;i++){
                count +=nums[i];
            }
            max = Math.max(max,count);
            left++;
            right++;
        }
        return 1.0*max/4;


    }
    public static void main(String[] args) {
        int []nums = {-1};
        int k =1;
        System.out.println(findMaxAverage(nums, k));
    }
}
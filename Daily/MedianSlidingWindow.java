/**
 *  leetcode 480
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianSlidingWindow {
    public static  double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len - k+1];
        int left = 0;
        int right = k - 1;
        int index = 0;
        // 维护一个窗口
        // 对窗口数据进行排序取中位数
        // 窗口暂停的条件是右边到了边界
        while (right < len) {
            // 排序返回中位数
            res[index++] = sortForMedian(nums, left, right, k);
            // 移动
            left++;
            right++;
        }
        return res;

    }
    public static double sortForMedian(int []nums,int left,int right,int k){

        int []window = new int[k];
        int index = 0;
        for(int i = left;i<=right;i++){
            window[index++] = nums[i];
        }
        Arrays.sort(window);
        // 根据K求中位数返回
        if(k%2==0){
            // 偶数个  数据过大会导致int不够的
            
            
           return 1.0*(window[k/2-1]/2+window[k/2]/2);
        }else{
            return window[k/2];
        }

    }
    


    /**
     * 构建一个小顶堆和大顶堆来解决问题
     * @param nums
     * @param k
     * @return
     */
    public static double[] medianSlidingWindowWithHeap(int[] nums, int k){
        


           return new double[2];

    }
    public static void main(String[] args) {
        int []nums = {2147483647,2147483647};
        int k = 2;
        double []res = medianSlidingWindow(nums, k);
        for (double i : res) {
            System.out.println(i);
        }
    }
} 

class DualHeap{
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    
}

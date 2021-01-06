/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sliding-window-maximum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;
public class MaxSlidingWindow {
    /**
     * 维护一个双端队列
     * 前端出去 后端压入模拟 数组的移动
     *  移动  len-k 次
     *  超时
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int moveTimes = len-k;
        int max = Integer.MIN_VALUE;
        int []res = new int[moveTimes+1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> pool = new LinkedList<>();
        // 把数据放入一个pool
        for (int num:nums ) {
            pool.add(num);
        }
        int times = k;
        while(times>0){
                // 初始化吧
            int curVal = pool.pollFirst();
            max = Math.max(max, curVal);
            queue.add(curVal);
            times--;
        }
        res[index++] = max;
        while(!pool.isEmpty()){
            int valFromPool = pool.pollFirst();
            //移除一个
            queue.pollFirst();
            // 加入一个池子里的
            queue.add(valFromPool);
            // 选最大的
            int curMax = Integer.MIN_VALUE;
            for (Integer cur : queue) {
                curMax = Math.max(cur,curMax);
            }
            res[index++]  = curMax;
        }
        return res;

    }
    
    /**
     * 双指针  超时
     */
    public static int[] maxSlidingWindowWithDouble(int []nums,int k){
        int start = 0;
        int end = start+k-1;
        int len = nums.length;
        int []res = new int[len-k+1];
        int index = 0;
        int max = Integer.MIN_VALUE;
        while(end<nums.length){
            if(index!=0&&nums[end]>max){
                max = nums[end];
            }else{
                for(int i = start;i<=end;i++){
                    max = Math.max(max,nums[i]);
                }
            }
            res[index++] = max;
            start++;
            end++;
        }
        return res;
    }
    /**
     *  同样是双端队列 为什么人家这么快
     * @param args
     */
    public static int[] maxSlidingWindowAd(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        // 前K个 维持最大值的位置信息的在队列中
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        //  
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 如果当前最大值的位置不在范围内，就去掉
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;

    }


    public static void main(String[] args) {
        int []nums = {1,3,-1,2,1};
           
        int k = 2 ;
        int []arr = maxSlidingWindowAd(nums, k);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
   
}

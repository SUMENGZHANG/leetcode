/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。

进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;

public class FindMedianSortedArrays {
    /** 
     *  暴力垃圾法 
     *  时间复杂度  O(m+n)
     *  空间   O(m+n)
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 控制两个数组的位置
        int indexOne = 0;
        int indexTwo = 0;
        // 结果
        double res = 0;
        // 根据总长度可以拿到我们需要的一个中位数点或者两个求平均值
        int total = nums1.length + nums2.length;
        int targetIndex = 0;
        int targetIndexTwo = 0;
        boolean flag = true;
        targetIndex = total / 2;
        targetIndexTwo = targetIndex+1;

        if (total % 2 != 0) {
            flag = false;
           
        }
        // 有一个为空
        if(nums1.length==0){
            res = flag?(nums2[targetIndex-1]+nums2[targetIndexTwo-1])/2:nums2[targetIndex];
        }
        if(nums2.length==0){
            res = flag?(nums1[targetIndex-1]+nums1[targetIndexTwo-1])/2:nums1[targetIndex];
        }

        // 通过两个指针加入值
        
        List<Integer> list = new LinkedList<>();
        while (indexOne <nums1.length || indexTwo <nums2.length) {                  // 时间复杂度 O(m+n)  空间复杂度 O（）
                if(nums1.length==indexOne){
                    list.add(nums2[indexTwo]);
                    indexTwo++;
                }else if(nums2.length==indexTwo){
                    list.add(nums1[indexOne]);
                    indexOne++;
                }else{
                    if(nums1[indexOne]<nums2[indexTwo]){
                        list.add(nums1[indexOne]);
                        indexOne++;
                    }else{
                        list.add(nums2[indexTwo]);
                        indexTwo++;
                    }
                }
                
                // 如果当前的数量正好满足目标位置
                if (indexOne + indexTwo == targetIndex+1) {
                    if (flag) {
                        
                        res =  (double)(list.get(indexOne+indexTwo-1) + list.get(indexOne+indexTwo-2)) / 2;
                        return res;

                    } else {
                        res =  (double)list.get(indexOne+indexTwo-1);
                        return res;
                    }

                }
            
            
            }

        return res;

    }
    
    /**
     *  去除List的维护
     *  时间复杂度 O(m+n)
     *  空间  O(1)
     */
    public static double findMedianSortedArraysSimple(int[] nums1, int[] nums2){
        // 得到总共的长度
        int len = nums1.length+nums2.length;
        // 定义两个指针用来定位
        int pointOne = 0;
        int pointTwo = 0;
        // 记录需要的值
        int left = 0;
        int right = 0;
        // 最多需要 len/2
        for(int i = 0;i<=len/2;i++){
            left = right;
            // 如果目前数组一没有到最后且数组二值大于数组一或者数组二到末尾了
            if(pointOne<nums1.length&&(pointTwo>=nums2.length||nums1[pointOne]<nums2[pointTwo])){
                right = nums1[pointOne++];
            }else{
                right = nums2[pointTwo++];
            }
            
        }
        if((len&1)==0){
            return (left+right)/2.0;

        }
        return right;
          
    }
    public static void main(String[] args) {
        int []nums1 = {0,0};
        int []nums2 = {0,0};
        System.out.println(findMedianSortedArraysSimple(nums1, nums2));
    }

}

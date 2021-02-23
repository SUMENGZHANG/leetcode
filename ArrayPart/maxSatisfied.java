public class maxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 问题简化为： 定长为X的窗口中，对应的生气时人流量最大的子数组

        // 维护一个定长的窗口
        int left = 0;
        int right = X-1;
        int max = 0;
        int maxHead = 0;
        int lastVal = 0;
        // 初始化最左边X长度的值
        for(int i = 0;i<X;i++){
            if(grumpy[i]==1){
                max += customers[i];
            }
        }
        lastVal = max;
        while(right<customers.length-1){
            right++;
            int curMax = lastVal;
            // 移动窗口 左边更新值
            if(grumpy[left]==1) curMax -=customers[left];
            if(grumpy[right]==1) curMax +=customers[right];
            // 移动窗口成功
            left++;
            
            // 如果最大值变大了，改变冷静期的开头
            if(curMax>max){
                max = curMax;
                maxHead = left;
            }
            lastVal = curMax;

        }
        
        // 统计最后返回结果
        int res = 0;
        for(int i = 0;i<customers.length;i++){
            if(grumpy[i]==0||(i>=maxHead&&i<maxHead+X)){
                res += customers[i];
            }
        }
        return res;

}
}

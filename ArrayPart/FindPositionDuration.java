/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。

你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/teemo-attacking
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPositionDuration {
    /**
     *  
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length<1) return 0;
        // 起码攻击一次
        // 目前毒持续的时间
        int timeKeep = timeSeries[0]+duration;
        int total = duration;
        for(int i = 1;i<timeSeries.length;i++){
            // 持续时间不足以撑到新一轮的攻击 攻击时艾希无毒
            if(timeSeries[i]>=timeKeep){
                timeKeep = timeSeries[i]+duration;
                total = total+duration;
            }else{
                // 攻击时艾希有毒,计算毒有几秒，扣除已经中毒的时间
                int realPosion = duration-timeKeep+timeSeries[i];
                timeKeep = timeKeep +realPosion;
                total = total+realPosion;
            }
             
        }
        return total;   
    }
    /**
     * 官方的解法更加优化 我的脑海里闪过这个方法一秒钟然后选择了👆 裂开
     */
    public static int findPosionedDurationAd(int []timeSeries,int duration){
        int len = timeSeries.length;
        if(len==0) return 0;
        int total = 0;
        for(int i = 0;i<len-1;i++){
            total += Math.min(timeSeries[i+1]-timeSeries[i], duration);
        }
        return total+duration;
    }


    public static void main(String[] args) {
        int []timeSeries = {1,2,3,4,5};
        int duration = 5;
        System.out.println(findPosionedDurationAd(timeSeries, duration));

    }
    
}

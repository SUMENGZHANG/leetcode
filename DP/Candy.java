/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/candy
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Candy {
    
    /**
     *  左规则和右规则，将局部最优转化成全局最优
     */
    public static int candy(int[] ratings) {
        // 当前这个人得到的糖果与临近的人分数有关
         int []sugar = new int[ratings.length];
         // 起码每个人发一个
         for (int i = 0;i<ratings.length;i++) {
             sugar[i] = 1;
         }
         // 满足每个值如果大于左边的，那么他的糖就多于左边
         for(int i =1;i<sugar.length;i++){
             if(ratings[i]>ratings[i-1]){
                 sugar[i] = sugar[i-1]+1;
             }

         }
         // 满足每个值如果大于右边的，那么他的糖就多于右边，且左边的规则也要满足
         for(int j = sugar.length-2;j>=0;j--){
             if(ratings[j]>ratings[j+1]){
                 sugar[j] = Math.max(sugar[j],sugar[j+1]+1);
             }
         }
         int res = 0;
         for (int i : sugar) {
             res = res+i;
         }
        
        return res;

    }
    
    
    /**
     * 
     * @param ratings
     * @return
     */
    public static int candyGreedy(int[] ratings){
        // 记录总数
        int count = 1;
        // 记录前一个值
        int pre = 1;
        // 记录下降的高度，高度差高于原本最高的值，则需要抬高原本的高度，使得下降到最地点也满足值为1
        int dec = 0;
        // 曾经的最高峰
        int top = 1;
        for(int  i =1;i<ratings.length;i++){
            if(ratings[i]>=ratings[i-1]){
                dec  =0;
                pre = ratings[i]==ratings[i-1]?1:pre+1;
                count +=pre;
                top = pre;
            }else{
                dec++;
                if(dec==top){
                    // 抬高
                    dec++;
                }
                count +=dec;
                pre = 1;



            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int []ratings = {1,3,5,4,3,2,1};
        System.out.println(candyGreedy(ratings));
        
    }
    
}

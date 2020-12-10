/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lemonade-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int left_five = 0;
        int left_ten = 0;
        int left_twenty = 0;
        for (int val : bills) {
            if(val==5){
                left_five++;
            }else if(val==10){
                left_ten++;
                left_five--;
                if(left_five<0){
                    return false;
                }
            }else if (val==20){
                left_twenty++;
                // 需要返回15  10+5  5*3
                if(!((left_five>=3)||(left_ten>0&&left_five>0))){
                    return false;
                }else{
                    // 为什么10的多的时候就把10给顾客呢，全给5不行吗？？
                    // 最好的解释是：5很灵活，能给10就给10 贪心算法吧
                    if(left_ten>0&&left_five>0){
                        left_ten--;
                        left_five--;
                    }else{
                        left_five -=3;
                    }
                }
            }


        }

        return true;

    }
    public static void main(String[] args) {
        int []bills = {5,5,5,10,20};
        boolean res  =  lemonadeChange(bills);
        System.out.println(res);
        
    }
    
}

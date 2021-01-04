/**
 * 
 */
public class MyAtoi {
    /**
     * 1. 遍历，得到的所有数值都放入一个容器
     * 2. 求出长度最长的，保存符号
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        char []arr = s.toCharArray();
        // 创建一个容器
        long []res = new long[s.length()];
        int []sign = new int[s.length()];
        // 快慢指针遍历 存入每一个数值
        int indexOne = 0;
        int indexTwo = 0;
        int count = 0;
        while(indexOne<arr.length){
            indexTwo = indexOne;
            // 在长度之内的数字
            while(indexTwo<arr.length&&((int)arr[indexTwo]>=0&&(int)arr[indexTwo]<=9)){
                indexTwo++;
            }
            // 切割字符串，然后往后挪
            String curVal = s.substring(indexOne,indexTwo);
            if(curVal!=null){
                res[count] = Long.parseLong(curVal);
                // 判断是否为负数
                if(indexOne==0||(indexOne>=1&&arr[indexOne-1]!='-')){
                    sign[count] = 0;
                }else{
                    sign[count] = 1;
                }
                
            }
            count++;
            indexOne = indexTwo+1;
        }
        // 
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i = 0;i<count;i++){
            long nowVal = 0;
            // 还原数字
            if(sign[i]==0){
                nowVal = res[i];
                
            }else{
                nowVal = -res[i];
            }

            // 考虑极值
            if(res[i]>Integer.MAX_VALUE) res[i] = Integer.MAX_VALUE;
            if(res[i]<Integer.MIN_VALUE) res[i] = Integer.MIN_VALUE;
            
           max = Math.max(res[i], max);
           min = Math.min(res[i],min);

        }


        return Math.abs(max)>Math.abs(min)?(int)max:(int)min;

    }
    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(myAtoi(s));


    }
    
}

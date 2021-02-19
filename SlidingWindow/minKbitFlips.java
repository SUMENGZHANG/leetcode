public class minKbitFlips {
    /**
     * 暴力法
     * @param A
     * @param k
     * @return
     */
    public int minBitFlips(int A[],int K){
        int len = A.length;
        int res = 0;
        for(int i =0;i<len;i++){
            if(A[i]==0){
                if(i+K>A.length) return -1;
                for(int j = i;j<i+K;j++){
                    // 异或
                    A[j]^= 1;
                }
                res++;
            }
        }
        return res;


    }

    /**
     *  差分数组求解
     * @param A
     * @param K
     * @return
     */
    public int minBitFlipsWithDiffArray(int []A,int K){
        int len  = A.length;
        // 创建一个diff数组
        int[] diff = new int[len+1];
        int count = 0;
        int revCnt = 0;
        for(int i= 0;i<len;i++){
            revCnt +=diff[i];
            // 得到需要被反转的数（0翻转偶数次后为0，1翻转奇数次为0）
            //  举例子： revCnt为奇数（偶数）的话，最后一位是1（0），&1得到1（0），1（0）^0得到是 1（0）
            //|=：两个二进制对应位都为0时，结果等于0，否则结果等于1；
            //&=：两个二进制的对应位都为1时，结果为1，否则结果等于0；
            //^=：两个二进制的对应位相同，结果为0，否则结果为1。
            if(((revCnt&1)^A[i])==0){
                if(i+K>len) return -1;
                // d[i] +1
                // d[i-k] -1
                diff[i]+=1;
                diff[i+K]-=1;
                revCnt +=1;
                count++;
            }
        }
        return count;


    }

    /**
     * 滑动窗口解决问题
     * @param A
     * @param K
     * @return
     */
    public int minBitFlipsWithSlidingWindow(int[] A,int K){
        int count = 0;
        int reSum = 0;
        for(int i = 0;i<A.length;i++){
            if(i-K>=0 && A[i-K]<0) reSum--;
            if(((reSum&1)^A[i])==0){
                if((reSum&1^A[i])==0){
                    if(i+K>A.length) return -1;
                    A[i]  = ~A[i];
                    reSum += 1;
                    count++;
                }

            }
        }
        return count;

    }
    
}

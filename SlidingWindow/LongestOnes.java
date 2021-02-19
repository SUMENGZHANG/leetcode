/**
 *  1004
 */
public class longestOnes {
    /**
     *  滑动窗口解决问题
     *  时复：O（n）
     *  空复：O（1）
     * @param A
     * @param k
     * @return
     */
    public static int longestOnes(int[] A,int K){
        int left = 0;
        int right = 0;
        int len = A.length;
        
        int max = 0;
        while(right<len){

            if(A[right]==0&&K>0){
                K--;
                right++;

            }else if(A[right]==0&&K<=0){
                if(A[left]==0) K++;
                left++;
            }else{
                right++;
            }
            max = Math.max(right-left,max);

        }
        return max;

    }

    /**
     * 参考大佬的，优化滑动窗口
     * 
     * 时复：O（n）
     * 空复：O（1）
     * @param A
     * @param k
     * @return
     */
    public int longestOnesSimple(int[] A,int k){
        int left = 0;
        int right = 0;
        while(right<A.length){
            
            if(A[right++]==0) k--;
            if(k<0&&A[left++]==0) k++;
        }
        return right-left;
    }


    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(longestOnes(A, K));
    }    
}

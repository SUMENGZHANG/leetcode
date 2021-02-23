/**
 *  1004
 */
public class LongestOnes {
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

    /**
     * 二分法解决问题
     * @param A
     * @param K
     * @return
     */
    public static int longestOneWithBinary(int[] A,int K){
        int n  = A.length;
        int res = 0;
        // 记录到 i 点，有几个0；
        int[] p = new int[n+1];
        for(int i = 1;i<=n;++i){
            p[i] = p[i-1]+(1-A[i-1]);
        }
       for(int right = 0;right<n;++right){
           
           int left = binarySearch(p, p[right+1]-K);
           res = Math.max(right-left+1,res);

       }
        return res;



    }
    /**
     *  p 单调递增是因为 0只会越来越多
     *  二分实现
     */
    public static int binarySearch(int[] p,int target){
        int low = 0;
        int high = p.length;
        while(low<high){
            int mid = (high-low)/2+low;
            if(p[mid]<target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }


    




    public static void main(String[] args) {
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(longestOneWithBinary(A, K));
    }    
}

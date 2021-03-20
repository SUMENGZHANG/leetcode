import java.util.*;
public class MaxEnvelopers {
    public int maxEnvelopers(int[][] envelpers){
        Arrays.sort(envelpers,new Comparator<int[]>(){
            public int compare(int[] e1,int[]e2){
                if(e1[0]!=e2[0]){
                    return e1[0]-e2[0];
                }else{
                    return e2[1]-e1[1];
                }

            }

        });

        // 现在已经按照第一位排好序了 就变成一个最大连续增子串问题
        int max = 0;
        for(int i = 0;ien)


    }
    
}

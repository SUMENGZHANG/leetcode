import java.util.*;
public class PartitionAd {
    public static void main(String[] args) {
        boolean[][] dp = new boolean[10][10];
        for(int i = 0;i<10;i++){
            Arrays.fill(dp[i],true);
        }
        int count = 0;
        for(int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                if(dp[i][j]) count++;

                
            }
        }
        System.out.println(count);

        
    }
}

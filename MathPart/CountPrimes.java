public class CountPrimes {
    public static int countPrimes(int n){
        if(n<=2) return 0;
        int count = 0;
        // 遍历，得到每一个需要被检测的数
        for(int i=2;i<n;i++){
            boolean flag = false;
            // 
            for(int j = 2;j*j<=i;j++){
                if(i%j==0) flag = true;
            }
            if(!flag) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        
    }
}

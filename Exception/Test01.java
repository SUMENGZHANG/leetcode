public class Test01 {
    public static void printn(int n){
        if(n>0){
            printn(n-1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        printn(100000);
    }
    
}

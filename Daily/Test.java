public class Test {
    public static void main(String[] args) {
        int temp = 0;
        char s = 's';
        
        System.out.println(s-'a');
        System.out.println(Math.pow(2,18));
        System.out.println(1<<18);
        System.out.println(1<<s);
        System.out.println(temp|(1<<s-'a'));
        int k  = temp|(1<<s-'a');
        System.out.println(k);
        k  = (k-1)&temp;
        System.out.println(k);
        System.out.println(52445203&52428817);
        System.out.println(2&3);
        System.out.println(144&143);
    }
}

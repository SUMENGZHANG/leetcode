import java.util.*;
public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
         map.put('I',1);
         map.put('V',5);
         map.put('X',10);
         map.put('L',50);
         map.put('C',100);
         map.put('D',500);
         map.put('M',1000);

        int len = s.length();
        int i = 0;
        int res = 0;
        while(i<len){
            if(s.charAt(i)=='I'){
                if(i+1<len&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                    res -=1;
                }else{
                    res +=1;
                }

            }else if(s.charAt(i)=='X'){
                if(i+1<len&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                    res -=10;

                }else{
                    res +=10;
                }

            }else if(s.charAt(i)=='C'){
                if(i+1<len&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                    res -=100;

                }else{
                    res +=100;
                }

            }else{
                res +=map.get(s.charAt(i));
            }
            i++;


        }
        return res;


    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}

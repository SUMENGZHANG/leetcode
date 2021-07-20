public class getLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for(int i =0;i<k;i++){
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0;i<k;i++){
            res[i] = arr[arr.length-1-i];


        }
        return res;
    
}
public static void main(String[] args) {
    int[] arr = {3,2,1};
    int k = 2;
    getLeastNumbers(arr,k);
    
}


}

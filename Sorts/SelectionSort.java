public class SelectionSort {
   public static void selectionSort(int[] arr){
       int minIndex;
       for(int i = 0;i<arr.length;i++){
           minIndex = i;
           for(int j = i+1;j<arr.length;j++){
               if(arr[minIndex]>arr[j]){
                   minIndex = j;
               }

           }
           int temp = arr[i];
           arr[i]  =arr[minIndex];
           arr[minIndex] = temp;
       }
   }
   public static void selectionSortTwo(int[] arr){
       int minIndex;
       int maxIndex;
       for(int i = 0;i<arr.length/2;i++){
           minIndex = i;
           maxIndex = i;
           for(int j = i+1;j<arr.length-i;j++){
               if(arr[minIndex]>arr[j]) minIndex = j;
               if(arr[maxIndex]<arr[j]) maxIndex = j;
           }
           // 排序完成
           if(maxIndex==minIndex) break;

           // 
           int min = arr[minIndex];
           arr[minIndex] = arr[i];
           arr[i] = min;
            
           if(maxIndex==i) maxIndex= minIndex;
           int lastIndex = arr.length-1-i;
           int max = arr[lastIndex];
           arr[lastIndex] = arr[maxIndex];
           arr[maxIndex] = max;

           
       }
   }
   public static void main(String[] args) {
       int[] arr = new int[]{
           3,2,14,23,32
       };
       selectionSortTwo(arr);
       for (int i : arr) {
           System.out.println(i);
       }
       
   }
    
}

import java.util.Stack;

/**
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。先序遍历：中左右

你可以假定该序列中的数都是不相同的。

参考以下这颗二叉搜索树：

二叉搜索数：
1. 左子节点数值小于根节点，右子节点数大于根节点
2. 先序遍历是指：中左右
 */
public class VerifyPreorder {
    
    /**
     * 暴力法
     */
    public static boolean verifyPreorder(int[] preorder) {
        
       for(int i=0;i<preorder.length;i++){
           // 假设当前点为最大点，往右遍历，如果碰到一个更大的，则说明那个更大的是一个根节点
           boolean flag = false;
           for(int j = i+1;j<preorder.length;j++){
               // 如果现在已经有一个根节点找到了，且右子节点数比左子节点数小直接完蛋
               if(flag&&preorder[j]<preorder[i]){
                   return false;
               }
               // 找到一个根节点
               if(preorder[j]>preorder[i]){
                   // 根节点
                   flag = true;
               }
                     
           }
       }
        return true;
    }
    
    /**
     * 单调栈实现
     * @param preorder
     * @return
     */
    public static boolean verifyPreorderAD(int[] preorder){
        // 维护一个单调栈
        int []stack = new int[preorder.length];
        int min = Integer.MIN_VALUE;
        int index = -1;

        // 遍历数据
        for (int i : preorder){
            // 右子树的值小于左子树的值，错误
            if(i<min){
                return false;
            }
            // 如果大于这个数则 i 为根 stack[index]为目前最小值
            while(index>-1&&i>stack[index]){
                min = stack[index];
                index--;
            }

            stack[++index] = i;  
        }
        return true;

    }

    

    public static void main(String[] args) {
        int []arr = {1,3,4,2};
        System.out.println(verifyPreorderAD(arr));
    }

    
}

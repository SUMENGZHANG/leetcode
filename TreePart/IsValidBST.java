import jdk.internal.org.objectweb.asm.util.TraceModuleVisitor;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // 经典错误 ： 左子树的右子节点值也要大于左子树的父节点， 添加 min max作为上下界
        // boolean left  = true;
        // boolean right = true;
        // if(root!=null){
        //     if(root.left!=null){
        //         if(root.left.val>=root.val) return false;
        //        left =  isValidBST(root.left);
        //     }
        //     if(root.right!=null){
        //         if(root.right.val<=root.val) return false;
        //         right = isValidBST(root.right);
        //     }

        // }
        
        // if(left==false||right==false) return false;
        // return true;
        return dfs(root,null,null);
      
    }
    public static boolean dfs(TreeNode root,Integer min,Integer max){
        if(root==null) return true;
        if(min!=null&&root.val<min) return false;
        if(max!=null&&root.val>max) return false;
        if(!dfs(root.right, root.val, max)) return false;
        if(!dfs(root.left,min,root.val)) return false;
        return true;



    }

}

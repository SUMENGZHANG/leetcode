/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
import java.util.*;

import javax.swing.tree.TreeNode;
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        
        boolean flag = true;
        while(flag){
            // 拿出所有的当前所有的对象
            // 将他们的子对象放入一个维护的有序队列
            List<Integer> list = new LinkedArrayList<>();
            while(!nodeList.isEmpty()){
                stack.push(nodeList.pollFirst());
            }
            while(!stack.isEmpty()){
                TreeNode curNode = stack.pop();
                if(curNode.left!=null){
                    nodeList.add(curNode.left);
                }else{
                    nodeList.add(new TreeNode(-1));
                }
                if(curNode.right!=null){
                    nodeList.add(curNode.right);
                }else{
                    nodeList.add(new TreeNode(-1));
                }

                list.add(curNode.val);
            }

            if(allNegative(list)) flag = false;
            if(!reverseEquals(list)) return false;
        }
        return true;
    }
    public static Boolean allNegative(List<Integer> list){
        for ( int val: list) {
            if(val!=-1) return false;
        }
        return true;

    }

    /**
     *  每一行对称
     * @param list
     * @return
     */
    public static Boolean reverseEquals(List<Integer> list){
        int []arr = (int [])list.toArray();
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            if(arr[left]!=arr[right]){
                return false;
            }
            left++;
            right--;
        }
    }

    /**
     * 镜像思考问题
     * @param root
     * @return
     */
    public boolean isSymmetricForLoop(TreeNode root){
        return check(root,root);


    }
    public static  boolean check(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}

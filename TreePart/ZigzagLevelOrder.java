import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.text.ParseException;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZigzagLevelOrder {
    /**
     * 个人摸索写法
     * 主要是利用了栈的思想，pop之后将他的儿子们塞进去，塞的时候先用一个容器存储子集然后集体塞入，达到层序遍历。
     * 
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);
        int level = 0;
        while (true) {
            List<TreeNode> curList = new LinkedList<>();
            LinkedList<Integer> curRes = new LinkedList<Integer>();
            while (!deque.isEmpty()) {
                TreeNode curNode = deque.pop();
                if (curNode.left != null)
                    curList.add(curNode.left);
                if (curNode.right != null)
                    curList.add(curNode.right);
                if (level % 2 == 0) {
                    curRes.addLast(curNode.val);

                } else {
                    curRes.addFirst(curNode.val);
                }

            }
            level++;
            res.add(curRes);
            if (curList.size() == 0)
                break;
            for (TreeNode treeNode : curList) {
                deque.add(treeNode);
            }

        }

        return res;

    }

    /** 
     *  力扣思想看起来比我的简洁
    */
    public static List<List<Integer>> zigzagLevelOrderAD(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        //  需要一个容器完成树的经典广度优先
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean isOrder = true;

        while(!deque.isEmpty()){
          Deque<Integer> curRes = new LinkedList<>();
          int size = deque.size();
           for(int i = 0;i<size;i++){
               TreeNode curNode = deque.poll();
               if(isOrder){
                   curRes.offerLast(curNode.val);

               }else{
                   curRes.offerFirst(curNode.val);

               }

               if(curNode.left!=null){
                   deque.add(curNode.left);
               }
               if(curNode.right!=null){
                   deque.add(curNode.right);
               }

          
           }
           isOrder = !isOrder;
           res.add(new LinkedList<Integer>(curRes));
           
            
        }
        return res;

    }


    public static void main(String[] args) throws ParseException {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = zigzagLevelOrderAD(root);
        for (List<Integer> list : res) {

            for (int val : list) {
                System.out.print(val);
            }
            System.out.println("_____________________");
        }

    }

}

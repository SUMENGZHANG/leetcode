import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        List<List<Integer>> res = new ArrayList<>();
        LinedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        int count  = 1;
        while(!stack.isEmpty()){
               int times = count;
                count = 0;
                List<Integer> curRes = new ArrayList<>();
                while(times > 0){
                    TreeNode curNode = stack.pollFirst();
                    curRes.add(curNode.val);
                    if(curNode.left!=null){
                        stack.addLast(curNode.left);
                        count++;
                    }
                    if(curNode.right!=null){
                        stack.addLast(curNode.right);
                        count++;
                    }
                    times--;

                }
                res.add(curRes);
                
            }


        }

    }
    


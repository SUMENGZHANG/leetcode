import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoStackForQueue {
    Stack<Integer> stackFront ;
    Stack<Integer> stackBack ;
    public TwoStackForQueue(){
        stackFront = new Stack<>();
        stackBack = new Stack<>();
       
    }
    
    public void appendTail(int value) {
        stackFront.push(value);
    }
    
    public int deleteHead() {
            
            /*恢复stackFront， 而stackBack为空  -- 思路一
            // 如果没有值返回-1
             if(stackFront.isEmpty()){
            return -1;
            }else{
            // 如果有值，就先把值压入stackBack，最后压入的是头
            while(!stackFront.isEmpty()){
                int cur = stackFront.pop();
                stackBack.push(cur);
            }
            // 把头pop返回达到删除的作用
             int head =  stackBack.pop();
             while(!stackBack.isEmpty()){
             int curBack = stackBack.pop();
             stackFront.push(curBack);*/

             // 其实不用每次都倒回去，如果stackBack不为空那么那个肯定有头数据 -- 思路二
             int head;
             // back不为空，那么就有之前存储的头
             if(!stackBack.isEmpty()){
                 head = stackBack.pop();
             }else{
                 // 为空的话，先把front的倒进back
                 while(!stackFront.isEmpty()){
                     stackBack.push(stackFront.pop());
                 }
                 // 取到头
                 head = stackBack.isEmpty()?-1: stackBack.pop();
            
        }
        return head;
    }
    
}

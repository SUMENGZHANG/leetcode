/**
 * Q:
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  解析
 * 1.记住栈先进先出的原则
 * 2.因为题目要求是任何操作都是事件复杂度为O(1)，所有遍历等求到极值的方法都不可取。采用一个栈来维持最小值
 * 
 * 
 */
public class MinStack {
    Stack<Integer> minStack = null;
    Stack<Integer> valStack = null;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        valStack = new Stack<>();
    }
    
    public void push(int x) {
      min = min>x?x:min;
      valStack.push(x);
      minStack.push(min);
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
       if(minStack.isEmpty()){
           min = Integer.MAX_VALUE;
       }else{
           min = minStack.peek();
       }

    }
    
    public int top() {
           return valStack.peek();
    }
    
    public int getMin() {
        return min; 
       
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

import java.util.*;
public class MyQueue {
    Stack<Integer> left;
    Stack<Integer> right;
    /** Initialize your data structure here. */
    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();


    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        left.push(x);

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!left.isEmpty()){
            int cur = left.pop();
            right.push(cur);
        }
        int topVal = right.pop();
        while(!right.isEmpty()){
            left.push(right.pop());
        }

        return topVal;

    }
    
    /** Get the front element. */
    public int peek() {
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        int topVal = right.peek();
        while(!right.isEmpty()){
            left.push(right.pop());
        }

        return topVal;

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(left.isEmpty()) return true;
        return false;

    }
    
}

package stack_queue.leetcode.p155;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    Deque<Integer> stack1=new LinkedList<>();
    Deque<Integer> stack2=new LinkedList<>();


    public Solution() {

    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else{
            if(stack2.peek()<=val){
                stack2.push(stack2.peek());
            }else{
                stack2.push(val);
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();

    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

}

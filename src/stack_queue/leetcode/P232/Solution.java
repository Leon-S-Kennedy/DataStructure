package stack_queue.leetcode.P232;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    Deque<Integer> stack1 =new LinkedList<>();
    Deque<Integer> stack2 =new LinkedList<>();

    public Solution() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int size=stack1.size();
        for(int i=0;i<size;i++){
            stack2.push(stack1.pop());
        }
        int r=stack2.pop();
        for(int i=0;i<size-1;i++){
            stack1.push(stack2.pop());
        }
        return r;
    }

    public int peek() {
        int size=stack1.size();
        for(int i=0;i<size;i++){
            stack2.push(stack1.pop());
        }
        int r=stack2.peek();
        for(int i=0;i<size;i++){
            stack1.push(stack2.pop());
        }
        return r;
    }


    public boolean empty() {
        return stack1.isEmpty();
    }

}

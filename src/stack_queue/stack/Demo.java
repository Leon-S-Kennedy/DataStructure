package stack_queue.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        Deque<Integer> stack=new LinkedList<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while(!stack.isEmpty()){
            System.out.println(stack.size());
            System.out.println(stack.peek());
            System.out.println(stack.size());
            System.out.println("++++++++++++++++++++++++");
            System.out.println(stack.size());
            System.out.println(stack.pop());
            System.out.println(stack.size());

            System.out.println("++++++++++++++++++++++++");
        }
    }
}

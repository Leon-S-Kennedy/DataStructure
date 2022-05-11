package stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo01 {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();

        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);

        while (!queue.isEmpty()){
            System.out.println(queue.size());
            System.out.println(queue.peek());
            System.out.println(queue.size());

            System.out.println("+++++++++++++++++");
            System.out.println(queue.size());
            System.out.println(queue.poll());
            System.out.println(queue.size());
            System.out.println("+++++++++++++++++");
        }
    }
}

package stack_queue.leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public final Queue<Integer> queue1 =new LinkedList<>();
    public final Queue<Integer> queue2 =new LinkedList<>();

    public Solution() {

    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        int size=queue1.size();
        for(int i=0;i<size-1;i++){
            int p=queue1.poll();
            queue2.offer(p);
        }
        int p=queue1.poll();
        for(int i=0;i<size-1;i++){
            queue1.offer(queue2.poll());
        }
        return p;
    }

    public int top() {
        int size=queue1.size();
        for(int i=0;i<size-1;i++){
            int p=queue1.poll();
            queue2.offer(p);
        }
        int p=queue1.poll();
        for(int i=0;i<size-1;i++){
            queue1.offer(queue2.poll());
        }
        queue1.offer(p);
        return p;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}

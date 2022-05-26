package heap.demo.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });
}

package heap.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo3 {
    public static void main(String[] args) {
/*
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
*/
        PriorityQueue<Integer> pq=new PriorityQueue<>(((o1, o2) ->-o1.compareTo(o2)));

        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        pq.offer(5);

        Integer peek = pq.peek();
        System.out.println(peek);
        System.out.println("=========================================");
        while (!pq.isEmpty()){
            Integer poll = pq.poll();
            System.out.println(poll);
        }
    }
}

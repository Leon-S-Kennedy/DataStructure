package heap.demo;

import java.util.PriorityQueue;

public class Demo1 {
    public static void main(String[] args) {
        // 使用 Long 类型作为优先级队列的元素类型
        // 由于 Long 类型本身具备比较能力（Long 本身实现了 Comparable）
        // Priority: 优先级
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // 乱序的放入元素
        pq.offer(3L);
        pq.offer(5L);
        pq.offer(1L);
        pq.offer(4L);

        // 查看队首元素 —— 最小的元素
        Long peek = pq.peek();
        System.out.println(peek);

        System.out.println("==================");
        while (!pq.isEmpty()) {
            Long poll = pq.poll();
            System.out.println(poll);
        }
    }
}

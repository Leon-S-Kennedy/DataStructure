package heap.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo2 {
    // 默认是不支持比较的（没有实现过 Comparable）
    static class Person {
        int pid;
        String name;

        Person(int pid, String name) {
            this.pid = pid;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "pid=" + pid +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    // 定义 Comparator，比较 pid 小的 Person 比较小
    static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.pid - o2.pid;
        }
    }

    public static void main(String[] args) {
        // 如何在不修改 Person 类定义的情况下，将 Person 作为 PriorityQueue 的元素类型？
        // 通过外部的 Comparator 去完成
        // Comparator 通过 PriorityQueue 的构造方法传入
        PersonComparator comparator = new PersonComparator();
        PriorityQueue<Person> pq = new PriorityQueue<>(comparator);
        pq.offer(new Person(1, "一"));
        pq.offer(new Person(9, "九"));
        pq.offer(new Person(3, "三"));
        pq.offer(new Person(7, "七"));
        pq.offer(new Person(5, "五"));

        Person peek = pq.peek();
        System.out.println(peek);   // 最小的 Person 对象，pid == 1
        System.out.println("=================");
        while (!pq.isEmpty()) {
            Person poll = pq.poll();
            System.out.println(poll);
        }
    }
}

package aboutCollection.capcity;

import java.util.ArrayList;
import java.util.List;

public class Capcity {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        // 5 是 size 还是 capacity？
        // 传入的是 capacity
        // 问 size 是多少？ size 仍然是 0
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        // 对于 ArrayList 来说，下标的合法性是和 size 有关还是和 capacity 有关？
        // 目前的合法下标 [0, 0)，任意下标都不是合法的
        list.set(0, 999);
        System.out.println(list);
    }

}

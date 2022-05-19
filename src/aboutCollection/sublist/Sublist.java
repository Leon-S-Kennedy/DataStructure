package aboutCollection.sublist;

import java.util.ArrayList;
import java.util.List;

public class Sublist {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(1);
        list.add(3);

        System.out.println(list);
        List<Integer> list2 = list.subList(1, 4);
        System.out.println(list2);

        // ArrayList 的 subList 实现，返回的并不是一个完全独立的 List
        // 而是原来 List 的一个 View
        // 做的是浅拷贝，不是深拷贝
        // 通过 subList 修改元素，会影响到原来的 List
        list2.set(0, 999);
        System.out.println(list2);
        System.out.println(list);
    }
}

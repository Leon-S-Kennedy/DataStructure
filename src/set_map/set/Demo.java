package set_map.set;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(10);
        set.add(20);

        System.out.println(set.last());//输出最大的Key
        System.out.println(set.first());//输出最小的Key

        System.out.println(set.floor(5));
        System.out.println(set.ceiling(5));

        System.out.println(set.higher(5));
        System.out.println(set.lower(5));

    }
}

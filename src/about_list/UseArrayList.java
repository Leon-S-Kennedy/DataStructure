package about_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {
    public static void main(String[] args) {
        List<String> list = new MyArrayList<>(Arrays.asList("Hello", "World", "你好", "世界"));

        // 凡是实现了 Iterable 的类的对象，都支持使用加强 for 的形式去遍历
        // 我们的 MyArrayList 实现了  List，隐含着实现了 Iterable 接口
        // 所以，我们的 MyArrayList 对象，也可以使用 foreach 的写法
        for (String s : list) {
            System.out.println(s);
        }

        // 迭代器之间互相独立的
//        Iterator<String> it1 = list.iterator();
//        Iterator<String> it2 = list.iterator();
//
//        it1.next();
//        it1.next();
//        System.out.println(it1.next()); // 你好
//        System.out.println(it2.next()); // Hello

//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            String s = it.next();
//            System.out.println(s);
//        }


//        Object[] objects = list.toArray();
//        String[] strings = list.toArray(new String[0]); // 为什么要传一个长度为 0 的数组
    }
}

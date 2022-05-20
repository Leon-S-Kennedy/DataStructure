package aboutCollection.about_iterator;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Demo01 {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 2, 7, 3, 9));
        Collection<Integer> list = new HashSet<>(Arrays.asList(1, 5, 2, 7, 3, 9));

        // 没有下标支持，这种遍历方式无法使用
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));    // 不再成立
//        }

        // x 指向了迭代器对象
        Iterator<Integer> x = list.iterator();
        while (x.hasNext()) {   // x.hasNext()    元素的个数 + 1
            System.out.println(x.next());        // x.next() 元素的个数
        }
        for (Integer integer : list) {   // x.hasNext()    元素的个数 + 1
            System.out.println(integer);        // x.next() 元素的个数
        }


//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 1
//
//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 5
//
//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 2
//
//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 7
//
//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 3
//
//        System.out.println(x.hasNext());    // true
//        System.out.println(x.next());       // 9
//
//        System.out.println(x.hasNext());    // false
    }
}

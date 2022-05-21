package aboutCollection.deepcopy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DeepCopy {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);

        List<Integer> c2 = new ArrayList<>(c);  // 是“深拷贝”：如果存的是引用，通过引用修改了元素的属性，则还是会影响的
        System.out.println(c);
        System.out.println(c2);

        c.set(0, 999);
        System.out.println(c);
        System.out.println(c2);
    }
}

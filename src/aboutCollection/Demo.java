package aboutCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Demo {
    //继承带来的引用指向
    Iterable<String> q=new ArrayList<>();
    Collection<String> w=new ArrayList<>();
    List<String> e=new ArrayList<>();
    ArrayList<String> r=new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        System.out.println(list.get(1));
        list.set(2,12);
        System.out.println(list);

        //LIST的排序
        list.sort(new Comparator<Integer>() {       //此处匿名类
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());

    }
}

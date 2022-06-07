package set_map.map;

import java.util.Map;
import java.util.TreeMap;

public class Demo01 {
    static class Person{
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        //此处一定要传入compator因为搜索树的实现需要有比较能力
        Map<Person,Integer> treeMap= new TreeMap<>((o1, o2) -> o1.id- o2.id);


        treeMap.put(new Person(1,"A"),1);
        treeMap.put(new Person(2,"B"),2);
        treeMap.put(new Person(3,"C"),3);
        treeMap.put(new Person(4,"D"),2);
        treeMap.put(new Person(5,"E"),1);

        System.out.println(treeMap);

        Person P=new Person(1,"A");

        System.out.println(treeMap.containsKey(P));
        //此处是true的原因是我们传入了compartor。不是用的equals，用的compartor。
    }

}

package aboutCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Demo01 {
    static class Person{
        public Integer uid;
        public String name;

        public Person(Integer uid, String name) {
            this.uid = uid;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "uid=" + uid +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return uid.equals(person.uid);
        }


        public static Collection<Person> creatCollection(){
            Collection<Person>list=new ArrayList<>();
            Person p1 = new Person(1, "hello");
            Person p2 = new Person(2, "Hello");
            Person p3 = new Person(3, "HELLO");
            Person p4 = new Person(4, "hELLO");
            list.add(p1);
            list.add(p2);
            list.add(p3);
            list.add(p4);
            return list;
        }

        public static void main(String[] args) {
            Person target=new Person(2,"Hello");
            Collection<Person> c = creatCollection();
            System.out.println(c);


            //以下两个方法依赖元素的相等性，如果不实现的话就会返回false
            System.out.println(c.contains(target));
            System.out.println(c.remove(target));
            System.out.println(c);
        }
    }
}

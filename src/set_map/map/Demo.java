package set_map.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Map<String,Integer> mp=new HashMap<>();
        mp.put("ab",1);
        mp.put("ac",1);
        mp.put("ad",1);
        mp.put("ae",1);
        mp.put("af",1);
        Integer ac = mp.get("ag");
        System.out.println(ac);

        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet());

        System.out.println(mp.remove("af", 2));
        System.out.println(mp.remove("af"));        //返回对应key的value值。

        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet());

        System.out.println(mp.put("ae", 2));            //返回原来的value值

        System.out.println(mp);

        System.out.println("===============================");
        Set<Map.Entry<String, Integer>> entries = mp.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }
    }
}

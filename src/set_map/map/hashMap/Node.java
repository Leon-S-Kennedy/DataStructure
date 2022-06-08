package set_map.map.hashMap;

import java.util.Map;

public class Node implements Map.Entry<String,Integer>{
    public String Key;
    public int value;

    public Node next;

    public Node(){
    }
    public Node(String key, int value) {
        this.Key=key;
        this.value=value;
    }

    @Override
    public String getKey() {
        return this.Key;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public Integer setValue(Integer value) {
        Integer oldValue=this.value;
        this.value=value;
        return oldValue;
    }

}

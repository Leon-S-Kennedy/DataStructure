package set_map.map.hashMap;

import java.util.*;

public class MyHashMap {
    private static final double THRESHOLD=0.75;
    private Node[] array;//链表头结点插在此处
    private int size;

    public MyHashMap() {
        this.array = new Node[7];
        this.size = 0;
    }

    public Integer get(String key){         //查找

        int n=key.hashCode();
        int index=n%array.length;

        Node head = array[index];

        //遍历整个链表，查找元素
        for(Node cur=head;cur!=null;cur=cur.next){
            if (key.equals(cur.Key)){
                return cur.value;
            }
        }
        return null;        //遍历结束没有查询到Key说明没有找到
    }
    public Integer put(String key ,int value){
        int n=key.hashCode();
        int index=n%array.length;

        Node head=array[index];
        for(Node cur=head;cur!=null;cur=cur.next){
            if (key.equals(cur.Key)){
                //此时找到了对应的元素，我们进行更新的操作
                int oldValue = cur.value;
                cur.value=value;
                return oldValue;
            }
        }
        Node node=new Node(key,value);
        //此处使用头插尾插都行，为了代码简单，我们使用头插法
        node.next=array[index];
        array[index]=node;
        size++;
        // TODO: 2022/3/26 扩容
        if((1.0*size/array.length)>THRESHOLD){
            ensureCapacity();
        }
        return null;            //插入成功返回null
    }

    private void ensureCapacity() {
        Node[] newArray=new Node[array.length*2];
        for (int i = 0; i < array.length; i++) {        //遍历数组中的每个元素
            Node next;//记录下一个节点
            for (Node cur=array[i];cur!=null ; cur=next) {//遍历链表的每个节点
                int n=cur.Key.hashCode();
                int index=n%newArray.length;

                next=cur.next;          //记录下一个节点
                //头插操作
                cur.next=newArray[index];
                newArray[index]=cur;
            }
        }
        array=newArray;
    }

    public Integer remove(String key){
        int n=key.hashCode();
        int index=n%array.length;
        Node cur=array[index];
        Node prev=null;
        if(array[index]!=null&&array[index].Key.equals(key)){
            Node head=array[index];
            array[index]=cur.next;
            return head.value;
        }
        while(cur!=null){
            if(cur.Key.equals(key)){
                prev.next=cur.next;
                return cur.value;
            }
            prev=cur;
            cur=cur.next;
        }
        return null;
    }
    public boolean remove(String key ,int value){
        int n=key.hashCode();
        int index=n%array.length;
        Node cur=array[index];
        Node prev=null;
        if(array[index]!=null&&array[index].Key.equals(key)&&array[index].value==value){
            array[index]=array[index].next;
            return true;
        }
        while(cur!=null){
            if(cur.Key.equals(key)&&cur.value==value){
                prev.next=cur.next;
                return true;
            }
            prev=cur;
            cur=cur.next;
        }
        return false;
    }
    public void clear(){
        Arrays.fill(array, null);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public Set <String> keySet(){
        Set<String> set=new HashSet<>();
        Set<Map.Entry<String,Integer>> nodes = this.entrySet();
        for (Map.Entry<String, Integer> node : nodes) {
            set.add(node.getKey());
        }
    return set;
    }
    public Collection<Integer> values(){
        List<Integer> list=new ArrayList<>();
        Set<Map.Entry<String,Integer>> nodes = this.entrySet();
        for (Map.Entry<String, Integer> node : nodes) {
            list.add(node.getValue());
        }
        return list;
    }
    public Set<Map.Entry<String,Integer>> entrySet(){
        Set<Map.Entry<String,Integer>> set=new HashSet<>();
        for (Node node : array) {
            Node cur;
            for (cur = node; cur != null; cur = cur.next) {
                set.add(cur);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        MyHashMap map=new MyHashMap();
        System.out.println(map.put("aa", 1));
        System.out.println(map.put("ab", 2));
        System.out.println(map.put("ac", 3));
        System.out.println(map.put("ad", 4));
        System.out.println(map.put("ae", 3));
        System.out.println(map.put("af", 2));
        System.out.println(map.put("ag", 1));
        System.out.println("==============================");
        System.out.println(map.put("aa", 100));
        System.out.println("==============================");
        System.out.println(map.get("am"));
        System.out.println(map.get("aa"));
        System.out.println("==============================");
        System.out.println(map.remove("aa", 1));
        System.out.println(map.remove("aa"));
        System.out.println(map.remove("aa"));
        System.out.println(map.remove("af", 2));
        System.out.println("==============================");
        System.out.println(map.keySet());
        System.out.println(map.values());
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey()+"=>"+entry.getValue());
        }
    }
}

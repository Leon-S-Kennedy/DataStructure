package genericity;

public class Demo<E> {
    //在本类中可以把E当作一种类型
    private E[] array;
    private int size;

    public Demo(){
        //泛型不允许定义数组;
        array=(E[])new Object[10];
        size=0;
    }
    public void add(E e){
        array[size]=e;
        size++;
    }
}

package about_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 是一个迭代器类，而不是要遍历的容器类
// 迭代器对象和顺序表对象的紧密相关的，所以，顺序表对象的属性逃逸到迭代器对象，我们是可以接受
// 实现的是 Iterator 不是 Iterable
public class MyArrayListIterator<E> implements Iterator<E> {
    // 我们是顺序表，记录当前走到哪个位置，最简单的办法就是通过下标来记录
    private int currentIndex;
    // 记录要遍历的顺序表中一共有几个元素
    private int size;
    // 记录要遍历的顺序表中的所有元素
    private E[] array;

    public MyArrayListIterator(int size, E[] array) {
        currentIndex = 0;
        this.size = size;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public E next() {
        if (currentIndex >= size) {
            throw new NoSuchElementException();
        }

        E currentElement = array[currentIndex];

        // 同时，让迭代器走向下一个元素
        currentIndex++;

        return currentElement;
    }
}

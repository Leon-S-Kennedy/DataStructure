package about_list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// MyArrayList<E> 定义了一个泛型类，其中 E 代表定义了一个类型变量，在其他位置，E 可以当作类型来使用
// implements List<E>  实现了 List 接口，其中 E 是作为一种类型使用，其具体的类型，来自使用 MyArrayList 时，传入的类型
public class MyArrayList<E> implements List<E> {
    private E[] array;
    private int size;

    // 定义构造方法
    public MyArrayList() {
        // 容量是 16，元素个数是 0 的情况
        array = (E[])new Object[16];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        array = (E[])new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(Collection<E> c) {
        this(c.size() * 2);
        addAll(c);
    }

    // TimeComplexity: O(1)
    @Override
    public int size() {
//        // 统一先抛出不支持的操作异常，回头去把关键方法重写
//        throw new UnsupportedOperationException();
        return size;
    }

    // TimeComplexity: O(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // TimeComplexity: O(n)
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            // 无法使用 equals 判断，否则会 NPE
            for (int i = 0; i < size; i++) {
                if (array[i] == o) {
                    return true;
                }
            }

            return false;
        } else {
            // 应该使用 equals 做相等性判断
            for (int i = 0; i < size; i++) {
                // array[i].equals(o);      不是每一个 array[i]，都能保证 != null
                // o.equals(array[i]);      这种写法对的（因为 o 做过非 null 的判断的）
                if (o.equals(array[i])) {   // 这里是让大家重点关注的内容
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(size, array);
    }


    // TimeComplexity: O(n)
    @Override
    public Object[] toArray() {
        // 不要让属性逃逸即可
        return Arrays.copyOf(array, size);
    }

    // TimeComplexity: O(n)
    /*
    <T> 是泛型方法
    和泛型类有类似的地方，也有不同的地方
    最关键的不同的地方，在于如何定义类型变量
    class SomeClass<E>              类型变量定义在类型的后边
    <T> 返回值类型 方法名(...)       类型变量定义在类型的后边
    定义完成之后，T 可以当成一个目前还不知道的具体类型来使用

    我们有两个类型变量: E 顺序表的元素类   T 返回数组的元素类型

    E 类型如果和 T 类型之间没有转换关系，可以出现 ClassCastExecption
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= size) {
            // 如果传入的数组能放下 list 中的所有元素
            // 把元素放到传入的数组 a 中即可
            System.arraycopy(array, 0, a, 0, size);

            return a;
        } else {
            // 否则，新建一个新的数组并返回
            T[] newArray = (T[]) new Object[size];

            System.arraycopy(array, 0, newArray, 0, size);

            return newArray;
        }
    }

    // TimeComplexity（最坏）: O(n)
    // TimeComplexity（平均）: O(1)
    @Override
    public boolean add(E e) {
        // 1. 确保容量够用
        ensureCapacity();

        array[size++] = e;

        /*
        add 方法继承自 Collection
        从 Collection 视角看，插入是可能失败的
        但从 List 视角看，插入是不会失败的
        所以，统一返回 true 即可。
         */
        return true;
    }

    // TimeComplexity: O(n)
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == o) {
                    // 将 [i + 1, size) 全部前移一个位置即可，把最后一个删除(置为 null)，size--
                    System.arraycopy(array, i + 1, array, i, size - i - 1);
                    array[--size] = null;
                    return true;
                }
            }

            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    System.arraycopy(array, i + 1, array, i, size - i - 1);
                    array[--size] = null;
                    return true;
                }
            }

            return false;
        }
    }

    // 判断 c 是不是 this 的子集
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // m: 集合 c 中的元素个数
    // n: 当前(this) list 中的元素个数
    // TimeComplexity（平均）: O(m)
    // TimeComplexity（最坏）: O(m * n)
    @Override
    public boolean addAll(Collection<? extends E> c) {
        // 遍历 c 中的所有元素，将其尾插到 this list 中

        // 1. 按照迭代器方式顺序 遍历 c 中的所有元素
        for (E e : c) {
            // 2. 尾插到当前 list 中
            add(e);
        }

        return true;
    }

    // m: 集合 c 中的元素个数
    // n: 当前(this) list 中的元素个数
    // TimeComplexity: O(m * n)
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e : c) {
            add(index, e);
        }

        return true;
    }

    // 只保留 list - c
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // 只保留 list 交集 c
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // TimeComplexity: O(n)
    @Override
    public void clear() {
        // 确保把 array 中的所有引用都置为 null
        // 目的：引用变成 null 之后，对象才可能被 GC 回收
        // 反之，对象可能永远不会回收
        // 对象在应用中已经没用了，但无法被回收。通常我们把这种现象称为对象泄露（内存泄露）
        Arrays.fill(array, null);
        size = 0;
    }

    // TimeComplexity: O(1)
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
        }

        return array[index];
    }

    // TimeComplexity: O(1)
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
        }

        E oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    // TimeComplexity: O(n)
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
        }

        ensureCapacity();

        // 将 [index, size) 的元素，统一后移一个位置 [index + 1, size]，一共 size - index 个元素
        System.arraycopy(array, index, array, index + 1, size - index);

        // 将要插入的元素放置到 index 位置
        array[index] = element;
        size++;
    }

    // TimeComplexity: O(n)
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
        }

        E oldValue = array[index];

        // 将 [index + 1, size) 全部前移一个位置 [index, size - 1)，一共 size - index - 1 个元素
        System.arraycopy(array, index + 1, array, index, size - index - 1);

        // 删除最后一个元素
        array[--size] = null;

        return oldValue;
    }

    // TimeComplexity: O(n)
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }

            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }

            return -1;
        }
    }

    // TimeComplexity: O(n)
    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }

            return -1;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }

            return -1;
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    // 我们的实现：TimeComplexity: O(n)
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // 我们不完全按照标准来，不是实现一个 View，而是返回一个新的 List
        // 区别：标准的要求，修改了返回的 list 之后，修改是可以反映到 this list
        //       我们现在的实现，是不会的
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }

        List<E> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(get(i));
        }

        return subList;
    }

    // TimeComplexity: O(n)
    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }

        array = Arrays.copyOf(array, array.length * 2);
    }
}

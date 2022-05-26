package heap.demo.priority_queue;

import java.util.Arrays;

// 直接使用 long 类型作为我们的元素类型，不考虑泛型了
public class MyPriorityQueue {
    // 很重要的属性：堆 = 数组 + 有效元素个数
    private long[] array;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 由于我们的元素类型是 long 类型，不需要考虑 Comparable 和 Comparator 的问题
    // 所以我们只需要一个构造方法即可
    public MyPriorityQueue() {
        array = new long[16];
        size = 0;
    }

    // O(log(n))
    public void offer(long e) {
        // 放入我们的优先级队列中，放入之后，保证堆的性质仍然是满足的
        ensureCapacity();

        array[size] = e;
        size++;

        // [size - 1] 就是刚刚插入的元素的位置
        shiftUp(array, size - 1);
    }

    // O(1)
    // 前提：size > 0
    public long peek() {
        // 返回堆顶元素
        if (size < 0) {
            throw new RuntimeException("队列是空的");
        }
        return array[0];
    }

    // O(log(n))
    public long poll() {
        // 返回并删除堆顶元素
        if (size < 0) {
            throw new RuntimeException("队列是空的");
        }

        long e = array[0];

        // 用最后一个位置替代堆顶元素，删除最后一个位置
        array[0] = array[size - 1];
        array[size - 1] = 0;        // 0 代表这个位置被删除了，不是必须要写的
        size--;

        // 针对堆顶位置，做向下调整
        shiftDown(array, size, 0);

        return e;
    }

    // 检查我们的优先级队列对象是否正确
    // 1. 0 <= size && size <= array.length
    // 2. 满足小堆的特性（任取结点（除开叶子结点），其值 <= 它的两个孩子的值（如果存在的话）
    public void check() {
        if (size < 0 || size > array.length) {
            throw new RuntimeException("size 约束出错");
        }

        // 如果每个结点都没问题，说明小堆成立
        for (int i = 0; i < size; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left >= size) {
                // 说明是叶子，跳过
                continue;
            }

            // 左孩子破坏了规则
            if (array[i] > array[left]) {
                throw new RuntimeException(String.format("[%d] 位置的值大于其左孩子的值了", i));
            }

            // 右孩子破坏了规则
            if (right < size && array[i] > array[right]) {
                throw new RuntimeException(String.format("[%d] 位置的值大于其右孩子的值了", i));
            }
        }
    }

    private void shiftDown(long[] array, int size, int index) {
        while (2 * index + 1 < size) {
            // 说明 index 一定有左孩子的
            int min = 2 * index + 1;
            int right = min + 1;
            if (right < size && array[right] < array[min]) {
                min = right;
            }

            if (array[index] <= array[min]) {
                return;
            }

            swap(array, index, min);

            index = min;
        }
    }

    private void swap(long[] array, int i, int j) {
        long t= array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }

        array = Arrays.copyOf(array, array.length * 2);
    }

    // 向下调整期间，不需要 size
    private void shiftUp(long[] array, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (array[parent] <= array[index]) {
                return;
            }

            swap(array, index, parent);
            index = parent;
        }
    }
}

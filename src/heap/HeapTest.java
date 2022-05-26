package heap;

public class HeapTest {
    /**
     * 小堆的向下调整，要求满足向下调整的前提
     * @param array 堆所在的数组
     * @param size  前 size 个元素视为堆中的元素
     * @param index 要调整位置的下标
     */
    public static void shiftDown(long[] array, int size, int index) {
        // 只要看到 int 类型的，基本就是下标或者个数，不是元素

        // 这里直接 while(true)即可
        // while (2 * index + 1 < size) {    如果这么写，下面就不用再进行叶子的判断
        while (true) {
            // 1. 判断 index 所在位置是不是叶子
            // 逻辑上，没有左孩子一定就是叶子了（因为完全二叉树这个前提）
            int left = 2 * index + 1;
            if (left >= size) {
                // 越界 -> 没有左孩子 -> 是叶子 -> 调整结束
                return; // 循环的出口一：走到的叶子的位置
            }

            // 2. 找到两个孩子中的最值【最小值 via 小堆】
            // 先判断有没有右孩子
            int right = left + 1;       // right = 2 * index + 2
            int min = left;             // 假设最小值就是左孩子，所以 min 保存的最小值孩子所在的下标
            if (right < size && array[right] < array[left]) {
                // right < size 必须在 array[right] < array[left] 之前，不能交换顺序
                // 因为先得确定有右孩子，才有比较左右孩子的意义
                // 有右孩子为前提的情况下，然后右孩子的值 < 左孩子的值
                min = right;            // min 应该是右孩子所在的下标
            }

            // 3. 将最值和当前要调整的位置进行比较，判断是否满足堆的性质
            if (array[index] <= array[min]) {
                // 当前要调整的结点的值 <= 最小的孩子值；说明这里也满足堆的性质了，所以，调整结束
                return; // 循环的出口一：循环期间，已经满足堆的性质了
            }

            // 4. 交换两个值，物理上对应的就是数组的元素交换 min 下标的值、index 下标的值
            long t = array[index];
            array[index] = array[min];
            array[min] = t;

            // 5. 再对 min 位置重新进行同样的操作（对 min 位置进行向下调整操作）
            index = min;
        }
    }

    /**
     * 创建小堆：从一个无规则数组开始，经过调整，得到一个小堆
     * @param array 存储堆元素的数组
     * @param size 前 size 元素视为堆中元素
     */
    public static void createHeap(long[] array, int size) {
        // 从最后一个非叶子结点的双亲开始
        // 最后一个结点的下标一定是: size - 1
        // 它的双亲一定是: ((size - 1) - 1) / 2 = (size - 2) / 2
        // 从后往前遍历，直到根也被向下调整过
        // [(size - 2) / 2, 0]  左闭右闭
        for (int i = (size - 2) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
//        long[] array = { 2, 5, 1, 7, 13, 3, 5, 9, 8 };
//        long[] array = { 27, 15, 19, 18, 28, 34, 65, 49, 25, 37 };
        long[] array = {1, 9, 1, 7, 2, 3, 2, 8, 5, 4, 3, 0, 1};
        createHeap(array, array.length);
    }
}

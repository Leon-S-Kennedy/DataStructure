package about_sort.sorting;

public interface ISort {
    /**
     * 返回算法的名称
     * @return
     */
    String name();

    /**
     * 执行具体的排序算法
     * @param array
     */
    void sort(int[] array);
}

package about_sort.sorting;

public interface IBuildArray {

    /**
     * 返回数组的名称
     * @return
     */
    String name();

    /**
     * 生成指定长度的数组
     * @param size
     * @return
     */
    int[] buildArray(int size);
}

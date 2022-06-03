package about_sort.sorting;

public class InsertSort implements ISort{
    @Override
    public String name() {
        return "插入排序";
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j >=0 ; j--) {
                if(array[j+1]>array[j]){
                    break;
                }else {
                    SortUtil.swap(array,j,j+1);
                }
            }
        }
    }
}

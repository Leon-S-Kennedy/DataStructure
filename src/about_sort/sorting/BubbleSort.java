package about_sort.sorting;

public class BubbleSort implements ISort{
    @Override
    public String name() {
        return "冒泡排序";
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flag=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    SortUtil.swap(array,j,j+1);
                    flag=true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
}

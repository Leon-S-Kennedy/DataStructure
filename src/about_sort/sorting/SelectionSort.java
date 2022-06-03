package about_sort.sorting;

public class SelectionSort implements ISort{
    @Override
    public String name() {
        return "选择排序";
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minindex=i;
            for (int j = i+1; j<array.length ; j++) {
                if(array[j]<array[minindex]){
                    minindex=j;
                }
            }
            SortUtil.swap(array,i,minindex);
        }
    }
}

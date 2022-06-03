package about_sort.sorting;

public class QuickSort implements ISort{
    @Override
    public String name() {
        return "快速排序";
    }

    @Override
    public void sort(int[] array) {
        quickSortRange(array,0,array.length-1);
    }

    private void quickSortRange(int[] array, int from, int to) {
        int size=to-from+1;
        if(size<=1){
            return;
        }
        int pi=partition(array,from,to);
        quickSortRange(array,from,pi-1);
        quickSortRange(array,pi+1,to);
    }

    private int partition(int[] array, int from, int to) {
        int pivot=array[to];
        int s=from;
        for (int i = from; i <to ; i++) {
            if(array[i]<pivot){
                SortUtil.swap(array,i,s);
                s++;
            }
        }
        SortUtil.swap(array,s,to);
        return s;
    }
}

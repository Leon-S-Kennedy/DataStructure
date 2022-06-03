package about_sort.sorting;

public class MergeSort implements ISort{
    @Override
    public String name() {
        return "归并排序";
    }

    @Override
    public void sort(int[] array) {
        mergeSortRange(array,0,array.length);
    }

    private void mergeSortRange(int[] array, int from, int to) {
        int size=to-from;
        int mid=from+size/2;
        if(size<=1){
            return;
        }
        mergeSortRange(array,from,mid);
        mergeSortRange(array,mid,to);

        merge(array,from,mid,to);
    }

    private void merge(int[] array, int from, int mid, int to) {
        int left=from;
        int right=mid;
        int dest=0;

        int size=to-from;
        int[] other = new int[size];

        while(left<mid && right<to){
            if(array[left]<array[right]){
                other[dest++]=array[left++];
            }else{
                other[dest++]=array[right++];
            }
        }
        while (left<mid){
            other[dest++]=array[left++];
        }
        while (right<to){
            other[dest++]=array[right++];
        }

        for (int i = 0; i < size; i++) {
            array[from+i]=other[i];
        }

    }
}

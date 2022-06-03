package about_sort.sorting;

public class HeapSort implements ISort{
    @Override
    public String name() {
        return "堆排序";
    }

    @Override
    public void sort(int[] array) {
       int[] arr=creatBigHeap(array);
        for (int i = 0; i < arr.length-1; i++) {
            SortUtil.swap(arr,0,array.length-i-1);
            shiftDown(arr,arr.length-1-i,0);
        }
    }

    private void shiftDown(int[] arr, int size, int index) {
        while (2*index+1<size){

            int left=2*index+1;
            int right=left+1;
            int maxindex=left;

            if(right<size && arr[right]>arr[maxindex]){
                maxindex=right;
            }

            if(arr[maxindex]<=arr[index]){
                break;
            }
            SortUtil.swap(arr,index,maxindex);

            index=maxindex;

        }
    }

    private int[] creatBigHeap(int[] array) {
        for (int i = (array.length-2)/2; i >=0 ; i--) {
            shiftDown(array,array.length,i);
        }
        return array;
    }

}

package about_sort.heap_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int [] arr){
        int [] array=creatHeap(arr);

        for (int i = 0; i < arr.length-1; i++) {
            swap(arr,0,array.length-1-i);
            shiftDown(array,array.length-1-i,0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        while (index*2+1<size){
            int max=index*2+1;
            int right=max+1;
            if(right<size&& array[max]<array[right]){
                max=right;
            }
            if(array[index]>=array[max]){
                return;
            }
            swap(array, max, index);
            index=max;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    private static int[] creatHeap(int[] arr) {
        for (int i = (arr.length-2)/2; i >=0 ; i--) {
            shiftDown(arr, arr.length,i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr= buildArray.buildRandomArray(40000);
        int[] copy= Arrays.copyOf(arr,arr.length);
        double t1=System.currentTimeMillis();
        heapSort(arr);
        double t2=System.currentTimeMillis();
        System.out.println((t2-t1)/1000);

        int[] array={1,4,3,6,2,5,9,7};
        heapSort(array);
        System.out.println(Arrays.toString(array));


    }
}

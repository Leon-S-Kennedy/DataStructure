package about_sort.selection_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort1(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minindex=i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j]<arr[minindex]){
                    minindex=j  ;
                }
            }
            swap(arr,minindex,i);
        }
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int maxindex=0;
            for (int j = 1; j < arr.length-i ; j++) {
                if(arr[j]>arr[maxindex]){
                    maxindex=j;
                }
            }
            swap(arr,maxindex,arr.length-i-1);
        }
    }

    private static void swap(int[] arr, int maxindex, int i) {
        int t=arr[maxindex];
        arr[maxindex]=arr[i];
        arr[i]=t;
    }

    public static void main(String[] args) {
        int[] arr= buildArray.buildRandomArray(40000);
        int[] copy= Arrays.copyOf(arr,arr.length);
        double t1=System.currentTimeMillis();
        selectionSort(arr);
        double t2=System.currentTimeMillis();
        System.out.println((t2-t1)/1000);

        int[] array={1,4,3,6,2,5,9,7};
        selectionSort(array);
        System.out.println(Arrays.toString(array));

    }
}

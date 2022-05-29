package about_sort.bubble_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag=true;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=false;
                }
            }
            if(flag){
                return;
            }
        }
    }

    private static void swap(int[] arr,int i, int i1) {
        int t=arr[i];
        arr[i]=arr[i1];
        arr[i1]=t;
    }

    public static void main(String[] args) {
        int[] arr= buildArray.buildRandomArray(40000);
        int[] copy=Arrays.copyOf(arr,arr.length);
        double t1=System.currentTimeMillis();
        bubbleSort(arr);
        double t2=System.currentTimeMillis();
        System.out.println((t2-t1)/1000);
    }
}

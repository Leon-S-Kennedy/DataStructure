package about_sort.insert_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j = i; j >=0 ; j--) {
                if(arr[j+1]>arr[j]){
                    break;
                }else{
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void insertSort1(int [] arr){
        for (int i=0;i<arr.length-1;i++){
            int k=arr[i+1];
            int j;
            for (j = i; j >=0&&k<arr[j]  ; j--) {
                arr[j+1]=arr[j];
            }
            arr[j+1]=k;
        }
    }


    private static void swap(int[] arr, int j, int i) {
        int t=arr[j];
        arr[j]=arr[i];
        arr[i]=t;
    }

    public static void main(String[] args) {
        int[] arr= buildArray.buildRandomArray(40000);
        int[] copy=Arrays.copyOf(arr,arr.length);
        double t1=System.currentTimeMillis();
        insertSort(arr);
        double t2=System.currentTimeMillis();
        System.out.println((t2-t1)/1000);
    }
}

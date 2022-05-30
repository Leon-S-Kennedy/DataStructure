package about_sort.shell_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr){
        int gap=arr.length/2;
        while (gap>1){
            insertSortWithGap(arr,gap);
            gap=gap/2;
        }
        insertSortWithGap(arr,1);
    }
    public static void insertSortWithGap(int[] arr,int gap){
/*
        for (int i = 0; i < arr.length-gap; i++) {
            int k=arr[i+gap];
            int j;
            for (j = i; j >=0&&k<arr[j] ; j=j-gap) {
                arr[j+gap]=arr[j];
            }
            arr[j+gap]=k;
        }
*/
        for (int i = 0; i < arr.length-gap; i++) {
            for (int j = i; j >=0 ; j=j-gap) {
                if(arr[j+gap]>arr[j]){
                    break;
                }else {
                    swap(arr,j+gap,j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        int[] arr= buildArray.buildRandomArray(4000000);
        int[] copy= Arrays.copyOf(arr,arr.length);
        double t1=System.currentTimeMillis();
        shellSort(arr);
        double t2=System.currentTimeMillis();
        System.out.println((t2-t1)/1000);

        int[] array={1,4,3,6,2,5,9,7,0,8};
        shellSort(array);
        System.out.println(Arrays.toString(array));

    }
}

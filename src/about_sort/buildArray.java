package about_sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class buildArray {
    public static int[] buildRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] buildOrderArray(int size) {
        int[] arr=buildRandomArray(size);
        Arrays.sort(arr);
        return arr;
    }
    public static int[] buildReArray(int size){
        int[] arr=buildOrderArray(size);
        int half=size/2;
        for (int i = 0; i < half; i++) {
            int t=arr[i];
            arr[i]=arr[size-1-i];
            arr[size-1-i]=t;
        }
        return arr;
    }
    public static int[] buildEqualArray(int size){
        int[] arr=new int[size];
        Arrays.fill(arr,1);
        return arr;
    }
}
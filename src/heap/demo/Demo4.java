package heap.demo;

import java.util.*;
public class Demo4 {
    public static void shiftDownSmall(int[] array,int size,int index){
        //向下调整（小堆）
        int left=2*index+1;
        while(left<size) {
            int right = left + 1;
            int min = left;
            if (right < size&&array[right] < array[left]){
                min = right;
            }
            if(array[index]>array[min]){
                swap(array,index,min);
                index=min;
                left=2*index+1;
            }else{
                break;
            }
        }
    }
    public static void shiftDownBig(int[] array,int size,int index){
        //向下调整（大堆）
        while (2 * index + 1 < size) {
            int m = 2 * index + 1;
            if (m + 1 < size && array[m + 1] > array[m]) {
                m++;
            }
            if (array[index] >= array[m]) {
                break;
            }
            swap(array, index, m);
            index = m;
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    public static void main(String[] args) {
        int[] small={27,15,19,18,28,34,65,49,25,37};
        shiftDownSmall(small,small.length,0);
        System.out.println(Arrays.toString(small));
        int[] big = { 100, 10, 88, 25, 40, 80, 70,18};
        shiftDownBig(big, big.length, 1);
        System.out.println(Arrays.toString(big));
    }
}
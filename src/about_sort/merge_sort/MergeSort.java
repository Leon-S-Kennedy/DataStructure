package about_sort.merge_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class MergeSort {
    private static void mergeSort(int[] array){
        mergeSortRange(array,0,array.length);
    }

    private static void mergeSortRange(int[] array, int from, int to) {
        int size=to-from;
        int mid=from+(size/2);
        if (size<=1){
            return;
        }
        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid,to);
        merge(array,from,mid,to);
    }

    private static void merge(int[] array, int from, int mid, int to) {
        int left=from;
        int right=mid;
        int dest=0;
        int size=to-from;
        int[] other=new int[size];

        while (left<mid && right<to){
            if(array[left]<=array[right]){
                other[dest]=array[left];
                dest++;
                left++;
            }else{
                other[dest++]=array[right++];
            }
        }
        //一定还有一个区间的元素还没有取完。所以一定要补上

        while (left<mid){
            other[dest++]=array[left++];
        }
        while (right<to){
            other[dest++]=array[right++];
        }

/*
        if(left<mid){
            other[dest]=array[left];
        }else if(right<to){
            other[dest]=array[right];
        }
        这个写法是错的，因为有可能剩下的区间不止一个元素没有填到other中，不同于合并链表只需要把指针放在头上就行
*/

        //此时我们需要将元素复制回去
        for (int i = 0; i < size; i++) {
            array[from+i]=other[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = buildArray.buildRandomArray(40000);
        int[] copy = Arrays.copyOf(arr, arr.length);
        double t1 = System.currentTimeMillis();
        mergeSort(arr);
        double t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / 1000);

        int[] array = {1, 4, 3, 6, 2, 5, 9, 7,3,6,0,12,3,4};
        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }
}

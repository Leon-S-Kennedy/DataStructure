package about_sort.quick_sort;

import about_sort.buildArray;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr) {
        quickSortRange(arr, 0, arr.length - 1);
    }

    public static void quickSortRange(int[] arr, int from, int to) {
        if (to <= from) {
            return;
        }
        int pi = partitionMethodA(arr, from, to);
        quickSortRange(arr, from, pi - 1);
        quickSortRange(arr, pi + 1, to);
    }

    private static int partitionMethodA(int[] array, int from, int to) {

        int pivot = array[to];
        int left = from;
        int right = to;
        //循环结束的条件就是left=right的时候。此时所有元素都被比较过了
        while (left < right) {
            //为了确保内层循环在变动的时候左指针超越右指针，需要在前面加上限制条件
            while (left < right && array[left] <= pivot) {
                left++;
            }
            //上面的这个循环结束后，表明此时left指针到了一个比pivot大的值处

            while (left < right && array[right] >= pivot) {
                right--;
            }
            //上面的这个循环结束后，表明此时right指针到了一个比pivot小的值处

            //此时需要做的就是将左右指针的值进行交换，然后继续开始比较
            int t = array[left];
            array[left] = array[right];
            array[right] = t;
        }
        //当所有的值比较完毕之后，现在left==right的值，此时我们的pivot在to位置，只需交换位置即可。

        int t = array[to];
        array[to] = array[left];
        array[left] = t;

        //交换位置后的pivot的下标为left,将其返回。以便下次递归调用。
        return left;
    }

    private static int partitionMethodB(int[] arr, int from, int to) {
        int pivot = arr[to];
        int left = from;
        int right = to;

        while (left < right) {

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
            //同样的，我们只是换一个方法来完成交换。假设此时的right（to,pivot）为坑，如果遇到不满足left<=pivot的就将该处的值填入坑中，同时坑的位置变成left
            //坑的作用就是我们不用进行复杂的swap()，而是记录位置。

            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            //此时坑的位置是left,所以将right的值填入left坑中

        }
        arr[left] = pivot;
        //循环结束后我们只需要将提前记录的pivot填入坑中即可。

        return left;

    }
    //以上方法AB的两种思路本质上是一样的，只不过是第二种利用了小技巧使得交换次数变少了



    private static int partitionMethodC(int[] array, int from, int to) {
        //利用遍历的方法，s的左边是小于pivot的值，s右边(包括s)是大于pivot的值。遍历区间是从左往右,直到遍历完成，交换s和最后的pivot即可
        int s = from;
        int pivot = array[to];

        for (int i = from; i < to; i++) {
            if (array[i] < pivot) {
                //当遇见比pivot小的值的时候，需要让这个值到s的前面，所以我们交换i和s的值，然后将后移一位。
                int t = array[i];
                array[i] = array[s];
                array[s] = t;

                s++;
            }
            //遇见大的值不用管，继续遍历即可。
        }
        //最后遍历结束之后将pivot的值和s处的值进行交换即可。
        array[to] = array[s];
        array[s] = pivot;

        return s;
    }

    //此方法思路上为以上方法的组合。
    private static int[] partitionMethodD(int[] array, int from, int to){
        //此方法将区间分割为3块分别是小于等于和大于三部分。其中s是区分小于和等于的边界。i相等于左指针，g相当于右指针。
        int s=from;
        int i=from;
        int g=to;
        int pivot=array[to];

        //当g>=i是比较还未完成
        while (g>=i){

            //当i的值等于pivot时，继续遍历不进行其他操作。
            if(array[i]==pivot){
                i++;
            }

            //当i的值小于pivot时，和C方法一样，交换并且后移即可
            else if(array[i]<pivot){
                swap(array,i,s);
                s++;
                i++;
            }

            //当i的值大于pivot时，交换i和g的值，此时的i不需要++,因为交换过来的值还没有比较，但是g是交换后的值，前移即可
            else {
                swap(array,i,g);
                g--;
            }
        }

        //返回s的前一个位置和i的位置，方便下次递归调用
        return new int[]{s-1,i};
    }

    private static void swap(int[] array, int i, int s) {
        int t=array[i];
        array[i]=array[s];
        array[s]=t;
    }
    public static void quickSort1(int[] arr) {
        quickSortRange(arr, 0, arr.length - 1);
    }

    public static void quickSortRange1(int[] arr, int from, int to) {
        if (to <= from) {
            return;
        }
        int[] indices = partitionMethodD(arr, from, to);
        int less=indices[0];
        int great=indices[1];
        quickSortRange(arr, from, less);
        quickSortRange(arr, great, to);
    }

    public static void main(String[] args) {
        int[] arr = buildArray.buildRandomArray(40000);
        int[] copy = Arrays.copyOf(arr, arr.length);
        double t1 = System.currentTimeMillis();
        quickSort(arr);
        double t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / 1000);

        int[] array = {1, 4, 3, 6, 2, 5, 9, 7};
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}

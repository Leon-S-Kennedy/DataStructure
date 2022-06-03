package about_sort.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ISort[] sorts=new ISort[]{
                new BubbleSort(),
                new SelectionSort(),
                new InsertSort(),
                new ShellSort(),
                new MergeSort(),
                new QuickSort(),
                new HeapSort()
        };
        IBuildArray[] buildArrays=new IBuildArray[]{
                new RandomArray(),
        };

        for (ISort sort : sorts) {
            System.out.println("=========================================");
            System.out.println("排序名称:"+sort.name());
            for (IBuildArray buildArray : buildArrays) {
                System.out.println("排序数组类型:"+buildArray.name());

                int[] array1=buildArray.buildArray(4_0000);
                int[] array2= Arrays.copyOf(array1,array1.length);

                long b = System.currentTimeMillis();
                sort.sort(array1);
                long e = System.currentTimeMillis();
                double ms=e-b;
                double s=ms/1000;
                System.out.println("排序耗时:"+s);


                Arrays.sort(array2);
                if(!Arrays.equals(array1, array2)){
                    System.out.println("排序错误！！！");
                    return;
                }else {
                    System.out.println("排序正确");
                }
            }
        }
    }
}

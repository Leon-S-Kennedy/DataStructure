package about_sort.sorting;

import java.util.Random;

public class RandomArray implements IBuildArray{
    @Override
    public String name() {
        return "随机数组";
    }

    @Override
    public int[] buildArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i]= random.nextInt();
        }
/*
        foreach内部实际上是使用了一个临时变量来值传递，所以并不会更改数组本身的值
        for (int i : array) {
            i=random.nextInt();
        }
*/
        return array;
    }
}

package aboutCollection.Array_List;

import java.util.Arrays;
import java.util.List;

public class Trans {
    public static void main(String[] args) {
        //array->list
        Integer[] array={1,1,1,1,1,1,1};
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);

        //list->array
        Object[] objects = list.toArray();
        System.out.println(objects.toString());

        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers));

    }
}

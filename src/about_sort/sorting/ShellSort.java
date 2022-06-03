package about_sort.sorting;

public class ShellSort implements ISort{
    @Override
    public String name() {
        return "希尔排序";
    }

    @Override
    public void sort(int[] array) {
        int gap=array.length/2;
        while(gap>1){
            insertSortWithGap(array,gap);
            gap=gap/2;
        }
        insertSortWithGap(array,1);
    }

    private void insertSortWithGap(int[] array, int gap) {
        for (int i = 0; i < array.length-gap; i++) {
            for (int j = i; j >=0 ; j=j-gap) {
                if(array[j+gap]>array[j]){
                    break;
                }else{
                    SortUtil.swap(array,j+gap,j);
                }
            }
        }
    }
}

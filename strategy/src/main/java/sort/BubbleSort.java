package sort;

public class BubbleSort  implements SortStrategy{
    @Override
    public int[] sort(int[] arr) {
        boolean swapped = true;

        while(swapped){
            swapped = false;
            for (int index = 0; index < arr.length - 1; index++) {
                if (arr[index] > arr[index + 1]) {
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                    swapped = true;
                }
            }
        }

        return arr;
    }

    @Override
    public String name() {
        return "Bubble Sort";
    }
}

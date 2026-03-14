package sort;

public class InsertionSort implements SortStrategy{
    @Override
    // references: https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/
    public int[] sort(int[] arr)
    {
        for (int index = 1; index < arr.length; ++index) {
            int key = arr[index];
            int back_index = index - 1;

            while (back_index >= 0 && arr[back_index] > key) {
                arr[back_index + 1] = arr[back_index];
                back_index = back_index - 1;
            }
            arr[back_index + 1] = key;
        }
        return arr;
    }

    @Override
    public String name(){
        return "Insertion Sort";
    }
}
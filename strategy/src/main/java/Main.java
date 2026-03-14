import sort.*;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int SMALL_SIZE = 30;
    private static final int LARGE_SIZE = 100_000;

    public static void main(String[] args) {
        int[] smallData = generateRandomArray(SMALL_SIZE);
        int[] largeData = generateRandomArray(LARGE_SIZE);

        SortContext sortContext = new SortContext(new BubbleSort());
        benchmark(sortContext,smallData);
        benchmark(sortContext,largeData);
        //
        sortContext.setStrategy(new InsertionSort());
        benchmark(sortContext,smallData);
        benchmark(sortContext,largeData);
        //
        sortContext.setStrategy(new HeapSort());
        benchmark(sortContext, smallData);
        benchmark(sortContext,largeData);
    }

    private static void benchmark(SortContext context, int[] arr) {
        long startTime = System.nanoTime();
        context.sort(arr);
        long totalTime = System.nanoTime() - startTime;

        System.out.println(" ==================== " + context.getStrategy().name() + " =======================");
        System.out.println("Sorting Algorithm Benchmark: ");
        System.out.println("Time (ns): " + totalTime);
        System.out.println("Time (seconds): " + totalTime / 1_000_000_000.0);
    }

    private static int[] generateRandomArray(int size) {
        Random random  = new Random();
        int[] arr  = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }
}

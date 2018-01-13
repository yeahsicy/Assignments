package ad325;

import java.util.*;

public class Util {

    public static int[] integers;
    static Random random = new Random();

    public static void randomGenerater(int number) {
        integers = new int[number];
        for (int i = number - 1; i >= 0; i--) {
            integers[i] = random.nextInt();
        }
    }

    public static int[] shellSort() {
        int[] clone = integers.clone();
        int n = clone.length;
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = clone[i];
                int j;
                for (j = i; j >= gap && clone[j - gap] > temp; j -= gap) {
                    clone[j] = clone[j - gap];
                }
                clone[j] = temp;
            }
        }
        return clone;
    }

    public static int[] insertionSort() {
        int[] clone = integers.clone();
        int n = clone.length;
        for (int i = 1; i < n; ++i) {
            int key = clone[i];
            int j = i - 1;
            //Move elements that are greater than key
            //to one position ahead of their current position 
            while (j >= 0 && clone[j] > key) {
                clone[j + 1] = clone[j];
                j = j - 1;
            }
            clone[j + 1] = key;
        }
        return clone;
    }

    public static int[] selectionSort() {
        int[] clone = integers.clone();
        int n = clone.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (clone[j] < clone[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = clone[min_idx];
            clone[min_idx] = clone[i];
            clone[i] = temp;
        }
        return clone;
    }

    public static void ReportWriter(String name, long time) {
        System.out.println(name + " execution time: " + time);
    }
}

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

    public static int[] mergeSort() {
        int[] clone = integers.clone();
        int n = clone.length;
        m_sort(clone, 0, n - 1);
        return clone;
    }

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void m_sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            m_sort(arr, l, m);
            m_sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static int[] quickSort() {
        int[] clone = integers.clone();
        int n = clone.length;
        q_sort(clone, 0, n - 1);
        return clone;
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void q_sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // Recursively sort elements before partition and after partition
            q_sort(arr, low, pi - 1);
            q_sort(arr, pi + 1, high);
        }
    }

    public static void ReportWriter(String name, long time) {
        System.out.println(name + " execution time: " + time);
    }
}

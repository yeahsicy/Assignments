package solution;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //initialize array values
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 100; i > 0; i--)
            arrayList.add(i);

        //Bubble Sort
        Integer[] integers = arrayList.toArray(new Integer[1]);
        long t0 = System.nanoTime();
        Sorts.bubbleSort(integers);
        long t1 = System.nanoTime();
        System.out.println("Bubble Sort Runtime: " + (t1 - t0) + " nanoseconds");

        //Merge Sort
        long t2 = System.nanoTime();
        Sorts.merge_sort(arrayList);
        long t3 = System.nanoTime();
        System.out.println("Merge Sort Runtime: " + (t3 - t2) + " nanoseconds");
    }
}

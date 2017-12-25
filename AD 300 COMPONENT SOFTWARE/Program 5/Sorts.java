package solution;

import java.util.*;

public class Sorts {

    public static void bubbleSort(Integer[] integers) {
        for (int j = integers.length; j > 1; j--)
            for (int i = 1; i < j; i++)
                if (integers[i - 1] > integers[i]) {
                    integers[i - 1] += integers[i];
                    integers[i] = integers[i - 1] - integers[i];
                    integers[i - 1] -= integers[i];
                }
    }

    public static ArrayList<Integer> merge_sort(ArrayList<Integer> integerList) {
        if (integerList.size() < 2) return integerList;
        ArrayList<Integer> Left = new ArrayList<>();
        ArrayList<Integer> Right = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (i < integerList.size() / 2)
                Left.add(integerList.get(i));
            else
                Right.add(integerList.get(i));
        }
        Left = merge_sort(Left);
        Right = merge_sort(Right);
        return merge(Left, Right);
    }

    static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> r = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0) < right.get(0))
                r.add(left.remove(0));
            else r.add(right.remove(0));
        }
        ArrayList<Integer> Temp = left.isEmpty() ? right : left;
        r.addAll(Temp);
        return r;
    }

}

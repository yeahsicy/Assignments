package solution;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> integerArrayList = GetSortedArrayList("src/solution/BS.txt");
        while (1 == 1) {
            Integer ReturnIndex = binarySearch(GetInput(), integerArrayList, 0, integerArrayList.size());
            System.out.println(GetResult(ReturnIndex));
        }
    }

    static Integer GetInput() {
        System.out.println("Please enter a number to search: ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return -1;
        return scanner.nextInt();
    }

    static ArrayList<Integer> GetSortedArrayList(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        while (scanner.hasNextInt())
            integerTreeSet.add(scanner.nextInt());
        return new ArrayList<>(integerTreeSet);
    }

    static Integer binarySearch(Integer target, ArrayList<Integer> integerList, Integer from, Integer To) {
        if (Objects.equals(from, To)) return -1;
        if (target < integerList.get((from + To) / 2))
            return binarySearch(target, integerList, from, (from + To) / 2);
        if (target > integerList.get((from + To) / 2))
            return binarySearch(target, integerList, (from + To) / 2 + 1, To);
        return (from + To) / 2;
    }

    static String GetResult(Integer r) {
        if (r == -1) return "Not found";
        return "The index of the element is " + r;
    }
}


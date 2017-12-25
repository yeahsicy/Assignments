package solution;

import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Integer> hashMap = new HashMap<>();
    static String temp = "";
    static String tag = " time(s) used";

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\solution\\agile_manifesto.txt");
        ToHashMap(file);
        PrintAlphabeticalOrder();
        System.out.println();
        PrintByNumber();
        System.out.println();
        PrintShortReport();
    }

    static void ToHashMap(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            temp = scanner.next().toLowerCase();
            if (temp.contains(",") || temp.contains("."))
                temp = temp.substring(0, temp.length() - 1);
            Integer curVal = hashMap.putIfAbsent(temp, 1);
            if (curVal != null)
                hashMap.replace(temp, curVal + 1);
        }
    }

    static void PrintAlphabeticalOrder() {
        System.out.println("Words in alphabetical order: ");
        hashMap.keySet().stream().sorted().forEach(s -> System.out.println(s + "\t" + hashMap.get(s) + tag));
    }

    static void PrintByNumber() {
        System.out.println("Words in order by the number of times: ");
        hashMap.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) return 1;
            if (o1.getValue() < o2.getValue()) return -1;
            return 0;
        }).forEach(s -> System.out.println(s.getKey() + "\t" + s.getValue() + tag));
    }

    static void PrintShortReport() {
        System.out.println("Short Report");
        System.out.println("I chose to use HashMap, because the words are unique while the times of them are not. ");
        System.out.println("Also, it makes the word and the used time in pair. ");
    }
}

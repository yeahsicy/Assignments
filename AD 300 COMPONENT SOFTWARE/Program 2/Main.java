package solution;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static ArrayList<String> arrayList = new ArrayList<>();
    static HashMap<String, Boolean> hashMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        ToArrayListFrom("src/solution/words.txt");
        RemoveDuplicate();
        PrintArr();
    }

    static void ToArrayListFrom(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
            arrayList.add(scanner.next());
    }

    static void RemoveDuplicate() {
        for (String str : arrayList
                ) {
            if (hashMap.putIfAbsent(str, true) != null)
                hashMap.replace(str, false);
        }
        Collection<String> Dups = hashMap.entrySet().stream().filter(p -> !p.getValue()).map(p -> p.getKey()).collect(Collectors.toList());
        arrayList.removeAll(Dups);
    }

    static void PrintArr() {
        System.out.println("The ArrayList with all duplicate words removed: ");
        arrayList.forEach(a -> System.out.print(a + " "));
    }
}

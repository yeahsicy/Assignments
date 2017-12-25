package solution;

public class Util {

    static int[] ints = new int[10];

    static void Add(int num) {
        int m = num % 10;
        for (int i = m; i < ints.length; i++)
            if (ints[i] == 0) {
                ints[i] = num;
                break;
            }
    }

    public static void Add(int[] nums) {
        for (int i : nums)
            Add(i);
    }

    public static void PrintOut() {
        for (int i : ints)
            System.out.print(i + " ");
    }
}

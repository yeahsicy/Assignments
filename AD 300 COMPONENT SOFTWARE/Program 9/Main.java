package solution;

public class Main {

    public static void main(String[] args) {
        TreeUtil util = new TreeUtil();

        //Program 9.1
        int[] ints1 = {18, 14, 20, 22, 36, 57, 61, 21, 79, 60, 81, 95, 90};
        int[] search1 = {14, 95, 90, 35, 17, 63};
        util.Insert(ints1);
        util.GetDepths(search1);
        System.out.println();

        //Program 9.2
        int[] ints2 = {34, 35, 37, 62};
        int[] search2 = {14, 95, 90, 35, 17, 63, 35, 62};
        util.Insert(ints2);
        util.GetDepths(search2);
        System.out.println();

        //Program 9.3
        util.ToArrayList();
        util.root = util.Rebuild(0, util.integerArrayList.size() - 1);
        int[] search3 = {14, 95, 90, 35, 17, 63, 35, 62};
        util.GetDepths(search3);
    }
}

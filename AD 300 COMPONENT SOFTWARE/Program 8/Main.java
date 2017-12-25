package solution;

public class Main {

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode();
        n0.value = 1;
        TreeNode n1 = new TreeNode();
        n1.value = 2;
        TreeNode n2 = new TreeNode();
        n2.value = 30;
        TreeNode n3 = new TreeNode();
        n3.value = 20;
        TreeNode n4 = new TreeNode();
        n4.value = 5;

        n0.left = n1;
        n0.right = n2;
        n1.right = n3;
        n2.left = n4;

        Util util = new Util();
        int count = util.Count(n0);
        int max = util.GetMax(n0);
        int sum = util.GetSum(n0);
    }
}

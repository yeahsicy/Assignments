package solution;

public class Util {

    public int Count(TreeNode node) {
        if (node == null) return 0;
        return Count(node.left) + Count(node.right) + 1;
    }

    public int GetSum(TreeNode node) {
        if (node == null) return 0;
        return GetSum(node.left) + GetSum(node.right) + node.value;
    }

    public int GetMax(TreeNode node) {
        if (node == null) return -1;
        return Math.max(node.value, Math.max(GetMax(node.left), GetMax(node.right)));
    }
}

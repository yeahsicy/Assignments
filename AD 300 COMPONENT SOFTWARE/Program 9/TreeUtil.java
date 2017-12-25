package solution;

import java.util.*;

public class TreeUtil {

    TreeNode root;
    TreeNode temp;
    TreeSet<Integer> integerHashSet = new TreeSet<>();
    ArrayList<Integer> integerArrayList;

    void Insert(int item) {
        if (root == null) {
            root = new TreeNode(item);
            return;
        }
        temp = root;
        while (true) {
            if (temp.val > item) {
                if (temp.left == null) {
                    temp.left = new TreeNode(item);
                    return;
                } else
                    temp = temp.left;
            }
            if (temp.val < item) {
                if (temp.right == null) {
                    temp.right = new TreeNode(item);
                    return;
                } else
                    temp = temp.right;
            }
        }
    }

    public void Insert(int[] ints) {
        for (int n : ints)
            Insert(n);
    }

    int GetDepth(TreeNode temp, int item, int depth) {
        if (temp == null) return 0;
        if (temp.val == item) return depth;
        if (temp.val > item) return GetDepth(temp.left, item, depth + 1);
        return GetDepth(temp.right, item, depth + 1);
    }

    public void GetDepths(int[] ints) {
        for (int n : ints) {
            String StrTemp = "Number: " + n + " ";
            int d = GetDepth(root, n, 1);
            StrTemp += d == 0 ? "is not found" : ("is found at depth " + d);
            System.out.println(StrTemp);
        }
    }

    void ValuesToSet(TreeNode node) {
        if (node == null) return;
        integerHashSet.add(node.val);
        ValuesToSet(node.left);
        ValuesToSet(node.right);
    }

    public void ToArrayList() {
        ValuesToSet(root);
        integerArrayList = new ArrayList<>(integerHashSet);
    }

    public TreeNode Rebuild(int left, int right) {
        if (right < left) return null;
        int mid = (right + left) / 2;
        TreeNode temp = new TreeNode(integerArrayList.get(mid));
        temp.left = Rebuild(left, mid - 1);
        temp.right = Rebuild(mid + 1, right);
        return temp;
    }
}

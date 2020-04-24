package com.jawadhyder.practice;

import com.jawadhyder.practice.util.BTNode;
import com.jawadhyder.practice.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricBTree {
    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * But the following [1,2,2,null,3,null,3] is not:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * @param args
     */
    public static void main(String[] args) {

        // Symmetric tree
        BTNode A7 = new BTNode(3, null, null);
        BTNode A6 = new BTNode(4, null, null);
        BTNode A5 = new BTNode(4, null, null);
        BTNode A4 = new BTNode(3, null, null);
        BTNode A3 = new BTNode(2, A6, A7);
        BTNode A2 = new BTNode(2, A4, A5);
        BTNode A1 = new BTNode(1, A2, A3);

        System.out.println(isSymmetric(A1));

        // Non symmetric tree
        BTNode N5 = new BTNode(3, null, null);
        BTNode N4 = new BTNode(3, null, null);
        BTNode N3 = new BTNode(2, null, N5);
        BTNode N2 = new BTNode(2, null, N4);
        BTNode N1 = new BTNode(1, N2, N3);

        System.out.println(isSymmetric(N1));

    }

    private static boolean isSymmetric(BTNode root) {
        if (root == null)
            return true;
        return isSymmetric_helper(Arrays.asList(root.left), Arrays.asList(root.right));
    }

    private static boolean isSymmetric_helper(List<BTNode> leftNodes, List<BTNode> rightNodes) {
        if (leftNodes.size() != rightNodes.size())
            return false;
        List<BTNode> newLeftNodes = new ArrayList<>();
        List<BTNode> newRightNodes = new ArrayList<>();
        for (int i=0; i<leftNodes.size(); i++) {
            BTNode left = leftNodes.get(i);
            BTNode right = rightNodes.get(rightNodes.size()-1-i);
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            newLeftNodes.add(left.left);
            newLeftNodes.add(left.right);
            newRightNodes.add(right.left);
            newRightNodes.add(right.right);
        }
        if (Helper.listContainsAllNull(leftNodes) && Helper.listContainsAllNull(rightNodes))
            return true;
        return isSymmetric_helper(newLeftNodes, newRightNodes);
    }

}

package com.jawadhyder.practice;

import com.jawadhyder.practice.util.BTNode;
import com.jawadhyder.practice.util.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SymmetricBTree_recursive_self {
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


        // Symmetric tree
        //[2,3,3,4,5,5,4,null,null,8,9,9,8]
        BTNode B13 = new BTNode(8, null, null);
        BTNode B12 = new BTNode(9, null, null);
        BTNode B11 = new BTNode(9, null, null);
        BTNode B10 = new BTNode(8, null, null);
        BTNode B9 = null;
        BTNode B8 = null;
        BTNode B7 = new BTNode(4, null, null);
        BTNode B6 = new BTNode(5, B12, B13);
        BTNode B5 = new BTNode(5, B10, B11);
        BTNode B4 = new BTNode(4, B8, B9);
        BTNode B3 = new BTNode(3, B6, B7);
        BTNode B2 = new BTNode(3, B4, B5);
        BTNode B1 = new BTNode(2, B2, B3);
        System.out.println(isSymmetric(B1));

    }

    private static boolean isSymmetric(BTNode root) {
        if (root == null)
            return true;
        return isSymmetric_helper(Arrays.asList(root));
    }

    // Approach is to iterate every row and check if the row is a palindrome. While iterating the current row, prepare next row items.
    private static boolean isSymmetric_helper(List<BTNode> thisLevelNodes) {
        if (Helper.listContainsAllNull(thisLevelNodes))
            return true; // means successfully we have reached end of tree
        List<BTNode> nextLevelNodes = new ArrayList<>();
        int halfListSize = thisLevelNodes.size()/2;
        for (int i=0; i<thisLevelNodes.size(); i++) {
            if (i <= halfListSize) {
                if (!nodeValIsEqual(thisLevelNodes.get(i), thisLevelNodes.get(thisLevelNodes.size()-1-i ))) {
                    return false;
                }
            }
            BTNode left = thisLevelNodes.get(i) != null ? thisLevelNodes.get(i).left : null;
            BTNode right = thisLevelNodes.get(i) != null ? thisLevelNodes.get(i).right : null;
            nextLevelNodes.add(left);
            nextLevelNodes.add(right);
        }
        return isSymmetric_helper(nextLevelNodes);
    }

    private static boolean nodeValIsEqual(BTNode a, BTNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        return true;
    }

}

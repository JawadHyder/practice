package com.jawadhyder.practice;

import com.jawadhyder.practice.util.BTNode;

import java.util.*;

/**
 * Give a binary tree, convert it into a List such that this tree
 *                0
 *            1       2
 *          3  4     5  6
 * becomes the following list of list
 * [[0],
 *  [1,2],
 *  [3,4,5,6]
 * ]
 *
 */

public class BTreeToList {
    static public void main( String args[] ) {
        BTNode N6 = new BTNode(6,null,null);
        BTNode N5 = new BTNode(5,null,null);
        BTNode N4 = new BTNode(4,null,null);
        BTNode N3 = new BTNode(3,null,null);
        BTNode N2 = new BTNode(2,N5,N6);
        BTNode N1 = new BTNode(1,N3,N4);
        BTNode N0 = new BTNode(0,N1,N2);

        List<List<BTNode>> result = binaryTreeToList(N0);
        for(List<BTNode> subList: result) {
            for(BTNode node: subList) {
                System.out.print(node.val);
                System.out.print(",");
            }
            System.out.print("\n");
        }
    }

    static public List<List<BTNode>> binaryTreeToList(BTNode root) {
        return binaryTreeToList_helper(Arrays.asList(root), new ArrayList<>());
    }

    // BFS recursive solution
    static private List<List<BTNode>> binaryTreeToList_helper(List<BTNode> thisLevelNodes, List<List<BTNode>> resultList) {
        if (thisLevelNodes.isEmpty()) {
            return resultList;
        }
        List<BTNode> nextLevelList = new ArrayList<>();
        for (BTNode btNode: thisLevelNodes) {
            if (btNode.hasLeft())
                nextLevelList.add(btNode.left);
            if (btNode.hasRight())
                nextLevelList.add(btNode.right);
        }
        resultList.add(thisLevelNodes);
        return binaryTreeToList_helper(nextLevelList, resultList);
    }

}

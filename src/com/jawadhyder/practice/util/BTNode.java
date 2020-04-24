package com.jawadhyder.practice.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree node
 */
public class BTNode {
    public int val;
    public BTNode left;
    public BTNode right;
    public BTNode(int val,BTNode left,BTNode right){
        this.val = val;
        this.left=  left;
        this.right= right;
    }

    /**
     * Get left and right node as List
     * @return List containing left and right node
     */
    public List<BTNode> getChildren() {
        List<BTNode> children = new ArrayList<>();
        if (left != null)
            children.add(left);
        if (right != null)
            children.add(right);
        return children;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }
}
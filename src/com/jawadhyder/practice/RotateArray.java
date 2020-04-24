package com.jawadhyder.practice;

public class RotateArray {
    /**
     * Rotate a given array n number of times.
     * For example:
     * arr = [1, 2, 3, 4, 5]
     * after rotating arr 2 times it become
     * [4, 5, 1, 2, 3]
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        arr = rotate_arr(arr, 2); // rotation = 2

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static int[] rotate_arr(int[] arr, int rotations) {
        int[] copy = new int[arr.length];
        for (int i=0; i< arr.length; i++) {
            int newPos = (i + rotations) % arr.length;
            copy[newPos] = arr[i];
        }
        return copy;
    }
}

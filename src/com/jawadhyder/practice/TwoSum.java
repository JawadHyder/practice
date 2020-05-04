package com.jawadhyder.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * For example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * One approach is n square but it is not optimized.
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int[] indices = twoSum(arr1, 9);
        for (int index: indices) {
            System.out.println(index);
        }
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        for (int i=0; i< arr.length; i++) {
            int num = target - arr[i];
            if (indexValueMap.get(num) != null)
                return new int[]{indexValueMap.get(num), i};
            if (!indexValueMap.containsKey(arr[i]))
                indexValueMap.put(arr[i], i);
        }
        throw new RuntimeException("No possible result");
    }


    // This is valid solution but the time complexity is O(N^2) which is not optimized
//    private static int[] twoSum(int[] arr1, int target) {
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = i+1; j < arr1.length; j++) {
//                if (arr1[i] + arr1[j] == target)
//                    return new int[]{i, j};
//            }
//        }
//        return null;
//    }
}

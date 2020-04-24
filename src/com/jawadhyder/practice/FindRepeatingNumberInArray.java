package com.jawadhyder.practice;

public class FindRepeatingNumberInArray {
    /**
     * An array with sequence of numbers and the maximum number in array (range) is given.
     * The sequence is not broken but unordered. And the duplicate number can be at any place.
     * For example
     * arr = [3, 1, 5, 3, 2, 4] // number 3 is repeating
     * Find the repeating number in the most efficient time and space complexity
     *
     * //
     * Possible solutions:
     * 1) create a hashmap and check if number is already inserted (but space complexity is problem because array length can be huge)
     * 2) do an n square nested loop but time complexity will be an issue
     * 3) find the sum of arithmetic series [n*(n+1)/2] and subtract with actual sum of array values. Result will be the duplicating number (Most efficient)
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 3, 2, 4};
        System.out.println(findDuplicate(arr, 5));
    }

    private static Integer findDuplicate(int[] arr, int range) {
        int sum = range*(range+1)/2;
        int array_sum = 0;
        for (int i: arr){
            array_sum+=i;
        }
        return array_sum-sum;
    }
}

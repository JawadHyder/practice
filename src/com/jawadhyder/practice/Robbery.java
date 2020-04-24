package com.jawadhyder.practice;

public class Robbery {

    /**
     * You have to rob houses. You cannot rob houses next to each other. You have to maximize the rob value.
     * An array contains the value of houses in sequence.
     * Write a function to tell the maximum value you can rob.
     * example: arr = [1,2,6,2,4,5,3] range = 6
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {1,2,6,2,4,5,3};
        System.out.println(rob_houses(arr));

        int[] arr2 = {1,5,4,6,2,1};
        System.out.println(rob_houses(arr2));
    }

    private static Integer rob_houses(int arr[]) {
        return rob_houses_helper(arr,0);
    }


//                   0
//                n/   \r
//             1           2
//          n/   \r      n/  \r
//          2     3      3    4

    private static Integer rob_houses_helper(int arr[], int index){
        if (index > arr.length-1){
            return 0;
        }
        int rob_val = 0;

        //rob
        rob_val+=arr[index];
        rob_val+=rob_houses_helper(arr,index+2);

        //don't rob
        int missed_val = 0;
        missed_val = rob_houses_helper(arr,index+1);


        return Math.max(rob_val,missed_val);
    }

}

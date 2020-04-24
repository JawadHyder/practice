package com.jawadhyder.practice;

public class Factorial {

    public static void main(String[] args) {

        // Factorial of numbers from 1 to 10 with iterative solution
        for (int i=1; i<=10; i++ ) {
            try {
                System.out.println(factorial(i));
            } catch (Exception e) {
                System.out.println("Something went wrong with " + i);
            }
        }

        System.out.println("--------------------------------");

        // Factorial of numbers from 1 to 10 with recursive solution
        for (int i=1; i<=10; i++ ) {
            try {
                System.out.println(factorialWithRecursion(i));
            } catch (Exception e) {
                System.out.println("Something went wrong with " + i);
            }
        }
    }

    private static Integer factorial(Integer num) throws Exception {
        if (num < 0)
            throw new Exception("Negative found");

        if (num == 0 || num == 1) {
            return 1;
        }

        int answer = 1;
        while (num > 0) {
            answer *= num;
            num--;
        }

        return answer;
    }

    private static Integer factorialWithRecursion(Integer num) throws Exception {
        if (num < 0)
            throw new Exception("Negative found");
        if (num == 0 || num == 1)
            return 1;
        return num * factorialWithRecursion(num-1);
    }
}

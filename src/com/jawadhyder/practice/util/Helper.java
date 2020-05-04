package com.jawadhyder.practice.util;

import java.util.List;

public class Helper {
    public static <T> boolean listContainsAllNull(List<T> list) {
        for (T item: list) {
            if (item != null)
                return false;
        }
        return true;
    }

    public static void println(int a) {
        System.out.println(a);
    }

    public static void assertEqualsPrint(int expected, int given) {
        if (expected == given)
            System.out.println("Pass | expected:" + expected + ", found:" + given);
        else
            System.out.println("Fail | expected:" + expected + ", found:" + given);
    }

    public static <T> void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
        System.out.println("------------------------------");
    }
}

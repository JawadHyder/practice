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
}

package com.jawadhyder.practice;

import com.jawadhyder.practice.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class StrongPasswordChecker {
    /**
     * A password is considered strong if below conditions are all met:
     *
     * It has at least 6 characters and at most 20 characters.
     * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
     * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
     * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
     *
     * Insertion, deletion or replace of any one character are all considered as one change.
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        Helper.assertEqualsPrint(5, strongPasswordChecker("a")); // 5
        Helper.assertEqualsPrint(3, strongPasswordChecker("aaa")); // 3
        Helper.assertEqualsPrint(2, strongPasswordChecker("abbbbb")); // 2
        Helper.assertEqualsPrint(0, strongPasswordChecker("1aAbcd")); // 0
        Helper.assertEqualsPrint(0, strongPasswordChecker("1aAbcdd")); // 0
        Helper.assertEqualsPrint(1, strongPasswordChecker("1aAbcddd")); // 1
        Helper.assertEqualsPrint(2, strongPasswordChecker("aaa1aAbcddd")); // 2
        Helper.assertEqualsPrint(2, strongPasswordChecker("111aAbcddd")); // 2
        Helper.assertEqualsPrint(2, strongPasswordChecker("ABABABABABABABABABAB1")); // 2
        Helper.assertEqualsPrint(7, strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa")); // 7
        Helper.assertEqualsPrint(3, strongPasswordChecker("abababababababababaaa")); // 3
        Helper.assertEqualsPrint(3, strongPasswordChecker("1234567890123456Baaaaa")); // 3
        Helper.assertEqualsPrint(2, strongPasswordChecker("1010101010aaaB10101010")); // 2
        Helper.assertEqualsPrint(3, strongPasswordChecker("1010101010aaaaB10101010")); // 3
        Helper.assertEqualsPrint(3, strongPasswordChecker("1010101010aaaaaB101010")); // 3
        Helper.assertEqualsPrint(3, strongPasswordChecker("aaaaabbbb1234567890ABA")); // 3
        Helper.assertEqualsPrint(5, strongPasswordChecker("aaaaaabbbb1234567890ABAa")); // 5
        Helper.assertEqualsPrint(4, strongPasswordChecker("aaaaaa1234567890123Ubefg")); // 4
    }



    public static int strongPasswordChecker(String s) {
        int one = 0, two = 0, chg = 0, p = 0, l = s.length(), r = 0, up = 0, lo = 0, d = 0;
        while (p < l) {
            char c = s.charAt(p);
            if (Character.isUpperCase(c)) up = 1;
            if (Character.isLowerCase(c)) lo = 1;
            if (Character.isDigit(c)) d = 1;
            if (p > 1 && c == s.charAt(p - 1) && c == s.charAt(p - 2)) {
                r = 2;
                while (p < l && s.charAt(p) == c) {
                    p++;
                    r++;
                }
                if (r % 3 == 0) one++;
                else if(r % 3 == 1) two++;
                chg += r / 3;
            } else p++;
        }
        int miss = 3 - up - lo - d;
        if (l < 6) {
            return Math.max(miss, 6 - l);
        } else if (l <= 20) {
            return Math.max(miss, chg);
        } else{
            int del = l - 20;
            chg -= Math.min(del, one);
            chg -= Math.min(Math.max(del - one, 0), two * 2) / 2;
            chg -= Math.max(del - one - 2 * two, 0) / 3;
            return del + Math.max(chg, miss);
        }
    }


//    public static int strongPasswordChecker(String s) {
//        List<Integer> repeatingCounts = repeatingCount(s, 3);
//        int repeatingReplacements = 0;
//        for (Integer thisCount: repeatingCounts) {
//            repeatingReplacements += thisCount / 3;
//        }
//
//        int upperLowerDigitChangeCount = 0;
//        upperLowerDigitChangeCount = hasLowerCase(s) ?  upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//        upperLowerDigitChangeCount = hasUpperCase(s) ? upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//        upperLowerDigitChangeCount = hasDigit(s) ? upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//
//        if (s.length() < 6) {
//            int lengthChangesCount = 6 - s.length(); // additions
//            return Math.max(lengthChangesCount, Math.max(upperLowerDigitChangeCount, repeatingReplacements));
//        }
//
//
//        else if (s.length() > 20) {
//            int lengthChangesCount = s.length() - 20; // deletions
//            if (repeatingReplacements == 0)
//                return upperLowerDigitChangeCount + lengthChangesCount;
//            else {
//                int changes = 0;
//                List<Integer> cost = new ArrayList<>();
//                // % 0 | remove one repetition with 1 deletion or 1 replacement
//                // % 1 | remove one repetition with 2 deletion or 1 replacement
//                // % 2 | remove one repetition with 3 deletion or 1 replacement
////                int lookingForDeletions = 1;
////                boolean reachedEnd = false;
////                while (lengthChangesCount > 0) {
////                    boolean deletionFound = false;
////                    for (Integer thisRepeatingCount: repeatingCounts) {
////                        int deletionsRequired = (thisRepeatingCount % 3) + 1;
////                        if (deletionsRequired == lookingForDeletions) {
////                            deletionFound = true;
////                            lengthChangesCount -= deletionsRequired;
////                            thisRepeatingCount -= deletionsRequired;
////                            changes += deletionsRequired;
////                        }
////                    }
////                    if (!deletionFound) {
////                        lookingForDeletions = (lookingForDeletions == 3 || lookingForDeletions > lengthChangesCount ? 1 : lookingForDeletions + 1);
////                        if (lookingForDeletions == 3)
////                            reachedEnd = true;
////                    }
////                    if (reachedEnd)
////                        break;
////                }
////
////
////                return changes + upperLowerDigitChangeCount + lengthChangesCount;
//
//
//
//
//
//
//
//
////                int i = 0;
////                int cycle = 1;
////                boolean madeChange = false;
////                while (lengthChangesCount > 0) {
////                    if ((repeatingCounts.get(i) -2) % 3 == cycle) {
////                        repeatingCounts.set(i, repeatingCounts.get(i) - cycle);
////                        lengthChangesCount -= cycle;
////                        changes += cycle;
////                    }
////                    if (repeatingCounts.get(i) < 3)
////                        repeatingCounts.remove(i);
////                    if (repeatingCounts.size() == 0)
////                        break;
////                    i++;
////                    if (i > repeatingCounts.size() -1) {
////                        i = 0;
////                        if (cycle == 3)
////                            break;
////                        cycle++;
////                    }
////                }
////                repeatingReplacements = 0;
////                for (Integer thisCount: repeatingCounts) {
////                    repeatingReplacements += thisCount / 3;
////                }
////                return changes + Math.max(upperLowerDigitChangeCount, repeatingReplacements) + lengthChangesCount;
//
//
////                while (repeatingCounts.size() > 0) {
////                    Integer repeatCount = repeatingCounts.get(i);
////                    int thisReplacements = repeatCount / 3;
////                    int remainder = repeatCount % 3;
////
////                    if (upperLowerDigitChangeCount > 0) { // replace to satisfy upperLowerDigitChangeCount
////                        int uldcBefore = upperLowerDigitChangeCount;
////                        upperLowerDigitChangeCount -= thisReplacements;
////                        if (upperLowerDigitChangeCount < 0) {
////                            thisReplacements += Math.abs(upperLowerDigitChangeCount);
////                            upperLowerDigitChangeCount = 0;
////                        }
////                        int uldcAfter = upperLowerDigitChangeCount;
////                        changes += (uldcBefore - uldcAfter);
////                        if (thisReplacements > 0) {
////                            int remainingRepeatCount = (thisReplacements * 3) + remainder;
////                            repeatingCounts.set(i, remainingRepeatCount);
////                        }
////                        else
////                            repeatingCounts.remove(i);
////                    } else { // Replace or delete whichever is best
////                        if ((repeatCount - (3-1)) < lengthChangesCount) {
////                            lengthChangesCount -= (repeatCount - 3-1);
////                            changes += (repeatCount - 3-1);
////                        }
////                        else if (lengthChangesCount > repeatCount) {
////
////                        }
////                    }
////
////                    i++;
////                    if (i > repeatingCounts.size())
////                        i = 0;
////                }
////                return changes + upperLowerDigitChangeCount + lengthChangesCount;
//            }
//        }
//        else {
//            return Math.max(upperLowerDigitChangeCount, repeatingReplacements);
//        }
//    }

//    private static boolean hasLowerCase(String s) {
//        if (s.length() == 0)
//            return false;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isLowerCase(s.charAt(i)))
//                return true;
//        }
//        return false;
//    }
//    private static boolean hasUpperCase(String s) {
//        if (s.length() == 0)
//            return false;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isUpperCase(s.charAt(i)))
//                return true;
//        }
//        return false;
//    }
//    private static boolean hasDigit(String s) {
//        if (s.length() == 0)
//            return false;
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i)))
//                return true;
//        }
//        return false;
//    }
//
//
//    private static List<Integer> repeatingCount(String s, int repetition) {
//        if (s == null || s.length() == 0)
//            return new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        char currentCharacter = s.charAt(0);
//        int repeatingCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == currentCharacter) {
//                repeatingCount++;
//            } else {
//                if (repeatingCount >= repetition) {
//                    result.add(repeatingCount);
//                }
//                currentCharacter = s.charAt(i);
//                repeatingCount = 1;
//            }
//        }
//        if (repeatingCount >= repetition) {
//            result.add(repeatingCount);
//        }
//
//        return result;
//    }
}






































//    public static int strongPasswordChecker(String s) {
//        List<Integer> repeatingCounts = repeatingCount(s, 3);
//        int repeatingReplacements = 0;
//        for (Integer r: repeatingCounts) {
//            repeatingReplacements += (r/3);
//        }
//
//        int upperLowerDigitChangeCount = 0;
//        upperLowerDigitChangeCount = hasLowerCase(s) ?  upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//        upperLowerDigitChangeCount = hasUpperCase(s) ? upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//        upperLowerDigitChangeCount = hasDigit(s) ? upperLowerDigitChangeCount : ++upperLowerDigitChangeCount;
//
//        if (s.length() < 6) {
//            int lengthChangesCount = 6 - s.length(); // additions
//            return Math.max(lengthChangesCount, Math.max(upperLowerDigitChangeCount, repeatingReplacements));
//        } else if (s.length() > 20) {
//            int lengthChangesCount = Math.abs(20 - s.length()); // deletions
//            if (repeatingCounts.isEmpty()) {
//                return lengthChangesCount + upperLowerDigitChangeCount;
//            }
//            else if (upperLowerDigitChangeCount == 0) {
//                int result = 0;
//                int repeatingCountsSize = repeatingCounts.size();
//                while (lengthChangesCount > 0) {
//                    if (repeatingCountsSize == 0)
//                        break;
//                    int thisRepeatSize = repeatingCounts.get(repeatingCountsSize -1);
//                    int thisExtras = thisRepeatSize % 3;
//                    int thisReplacements = thisRepeatSize / 3;
//                    lengthChangesCount -= thisReplacements;
//                    lengthChangesCount -= thisExtras;
//                    result += thisReplacements + thisExtras;
//                    repeatingCountsSize--;
//                }
//                if (lengthChangesCount > 0)
//                    result += Math.abs(lengthChangesCount);
//                else {
//                    while (repeatingCountsSize > 0) {
//                        int thisRepeatSize = repeatingCounts.get(repeatingCountsSize -1);
//                        int thisExtras = thisRepeatSize % 3;
//                        int thisReplacements = thisRepeatSize / 3;
//                        lengthChangesCount -= thisReplacements;
//                        result += thisReplacements + thisExtras;
//                        repeatingCountsSize--;
//                    }
//                }
//                return result;
//            } else {
////                return Math.max(lengthChangesCount, repeatingReplacements) + upperLowerDigitChangeCount;
//                if ()
//            }
//        } else {
//            return Math.max(upperLowerDigitChangeCount, repeatingReplacements);
//        }
//    }
package com.thoughtworks.twu.intro;

import com.sun.tools.javac.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Diamond {

    public static void printDiamond(int n) {
        printShiftedIsocelesTrangleOfSize(n - 1);
        Triangle.printHorizontalLine(n + 2);
        printReversedAndShiftedIsocelesTriangleOfSize(n - 1);
    }

    private static void printShiftedIsocelesTrangleOfSize(int n) {
        printIsoscelesTriangle(n, 1, false);
    }

    public static void printIsocelesTriangleOfSize(int n) {
        printIsoscelesTriangle(n, 0, false);
    }

    private static void printReversedAndShiftedIsocelesTriangleOfSize(int n) {
        printIsoscelesTriangle(n, 1, true);
    }

    private static void printIsoscelesTriangle(int n, int whitespaceShift, boolean reversed) {
        List<Pair<Integer,Integer>> whitespaceAndAsteriskNumbers = computeWhitespaceAndAsteriskNumbersForNLines(n);
        if(reversed)
            Collections.reverse(whitespaceAndAsteriskNumbers);
        whitespaceAndAsteriskNumbers.forEach(pair -> {
            printWhitespaces(pair.fst + whitespaceShift);
            Triangle.printHorizontalLine(pair.snd);
        });
    }

    private static void printWhitespaces(int n) {
        IntStream.range(0, n).forEach(i -> System.out.print(" "));
    }

    private static List<Pair<Integer, Integer>> computeWhitespaceAndAsteriskNumbersForNLines(int n) {
        Stream<Integer> whitespaceCounts = computeWhitespaceNumbersForNLines(n).boxed();
        Stream<Integer> asteriskCounts = computeAsteriskNumbersForNLines(n).boxed();
        return Utils.zip(whitespaceCounts, asteriskCounts).collect(Collectors.toList());
    }

    private static IntStream computeWhitespaceNumbersForNLines(int n) {
        return IntStream.iterate(n-1, i -> i - 1).limit(n);
    }

    private static IntStream computeAsteriskNumbersForNLines(int n) {
        return IntStream.iterate(1, i -> i + 2).limit(n);
    }

    public static void printDiamondWithName(int n) {
        printShiftedIsocelesTrangleOfSize(n - 1);
        printMyName();
        printReversedAndShiftedIsocelesTriangleOfSize(n - 1);
    }

    private static void printMyName() {
        System.out.println("Mike");
    }
}

package com.dds.learn.java;

public class EnergyPacketDistributionTest {

    private static int passed = 0;

    public static void main(String[] args) {
        EnergyPacketDistribution distribution = new EnergyPacketDistribution();

        assertResult("sample input", distribution.solution(new long[] {10, 20, 30}, 5), 10);
        assertResult("single packet exact split", distribution.solution(new long[] {100}, 4), 25);
        assertResult("more agents than available unit packets", distribution.solution(new long[] {2, 3}, 10), 0);
        assertResult("null packets", distribution.solution(null, 3), 0);
        assertResult("empty packets", distribution.solution(new long[] {}, 3), 0);
        assertResult("zero agents", distribution.solution(new long[] {5, 10}, 0), 0);
        assertResult("mixed packet sizes", distribution.solution(new long[] {8, 15, 24}, 7), 6);
        assertResult("large values", distribution.solution(new long[] {1_000_000_000L, 1_000_000_000L}, 3), 500_000_000L);

        System.out.println("All custom test cases passed: " + passed);
    }

    private static void assertResult(String testName, long actual, long expected) {
        if (actual != expected) {
            throw new AssertionError(
                testName + " failed. Expected " + expected + " but got " + actual
            );
        }

        passed++;
        System.out.println("Passed: " + testName);
    }
}
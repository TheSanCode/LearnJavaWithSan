package com.dds.learn.java;

/*
# Plan
1. Read the input array containing n distinct numbers from the range [0, n].
2. Compute the expected sum of the full range using n * (n + 1) / 2.
3. Compute the actual sum of all values present in the array.
4. Return expected sum minus actual sum as the missing value.
*/
public class MissingNumbers {

    public static int findMissing(int[] nums) {
        // n is used as the upper bound of the expected range [0, n].
        int n = nums.length;

        // Sum of the complete range if no number were missing.
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        // Aggregate what is currently present in the input.
        for (int num : nums) {
            actualSum += num;
        }

        // The difference identifies the missing number.
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // Traceable sample run.
        int[] nums = {3, 0, 1};
        System.out.println(findMissing(nums)); // Output: 2
    }
}

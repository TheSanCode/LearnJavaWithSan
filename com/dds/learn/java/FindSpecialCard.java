package com.dds.learn.java;


/*
#plan
1. Understand the problem and identify the input/output.
2. Use an efficient approach to solve it within the required constraints.
3. Add clear inline comments for readability.
4. Test with normal cases, edge cases, and minimum/maximum constraints.
5. Return the final result in the expected format.
*/

import java.util.*;

public class FindSpecialCard {

    public static int solution(int[] cards) {
        // Frequency array based on given constraint: 1 <= cards[i] <= 100
        int[] freq = new int[101];
        int sum = 0; // Initialize sum to 0 to handle the case where no special cards are found
        // Validate that all cards are within the constraint: 1 <= cards[i] <= 100
    for (int card : cards) {
        if (card < 1 || card > 100) {
            throw new IllegalArgumentException("Card value " + card + " is out of bounds. Must be between 1 and 100.");
        }
    }
try {
    

        // Count how many times each card appears
        for (int card : cards) {
            freq[card]++;
        }

        

        // Add only cards that appear exactly once
        for (int card : cards) {
            if (freq[card] == 1) {
                sum += card;
            }
        }
        } catch (Exception e) {
    // TODO: handle exception
    System.out.println("An error occurred: " + e.getMessage());
    sum =-1; // Set sum to -1 in case of any exception, as we cannot determine the special cards
}

        return sum;
    }

    public static void main(String[] args) {
        // Custom test cases
        System.out.println(solution(new int[]{2, 3, 1, 3})==3?"Pass":"Fail"); // Expected: 3
        System.out.println(solution(new int[]{1, 2, 2, 3, 4, 4})==4?"Pass":"Fail"); // Expected: 4
        System.out.println(solution(new int[]{5})==5?"Pass":"Fail"); // Expected: 5
        System.out.println(solution(new int[]{7, 7, 7})==0?"Pass":"Fail"); // Expected: 0
        System.out.println(solution(new int[]{1, 2, 3, 4})==10?"Pass":"Fail"); // Expected: 10
        System.out.println(solution(new int[]{-1, -1, 1, 1}) !=-1?"Pass":"Fail"); // Expected: Fail or RTE due to negative values, but we will ignore this case as per constraints.

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of cards: ");
        int n = scanner.nextInt();
        int[] userCards = new int[n];
        System.out.println("Enter card values:");
        for (int i = 0; i < n; i++) {
            userCards[i] = scanner.nextInt();
        }
        System.out.println("Sum of special cards: " + solution(userCards));
        scanner.close();

    }
}
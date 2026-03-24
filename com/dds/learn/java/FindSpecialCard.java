package com.dds.learn.java;

import java.util.*;

public class FindSpecialCard {

    public static int solution(int[] cards) {
        // Frequency table for card values in the allowed range [1, 100].
        int[] freq = new int[101];
        int sum = 0; // Remains 0 when there are no unique cards.
        // Reject invalid card values before counting.
    for (int card : cards) {
        if (card < 1 || card > 100) {
            throw new IllegalArgumentException("Card value " + card + " is out of bounds. Must be between 1 and 100.");
        }
    }
try {
            // Count occurrences of each card.
        for (int card : cards) {
            freq[card]++;
        }

        

            // Sum only the cards that appear exactly once.
        for (int card : cards) {
            if (freq[card] == 1) {
                sum += card;
            }
        }
        } catch (Exception e) {
        // Fall back to -1 when an unexpected runtime error occurs.
    System.out.println("An error occurred: " + e.getMessage());
        sum =-1;
}

        return sum;
    }

    public static void main(String[] args) {
        // Quick checks for common scenarios.
        System.out.println(solution(new int[]{2, 3, 1, 3})==3?"Pass":"Fail"); // Expected: 3
        System.out.println(solution(new int[]{1, 2, 2, 3, 4, 4})==4?"Pass":"Fail"); // Expected: 4
        System.out.println(solution(new int[]{5})==5?"Pass":"Fail"); // Expected: 5
        System.out.println(solution(new int[]{7, 7, 7})==0?"Pass":"Fail"); // Expected: 0
        System.out.println(solution(new int[]{1, 2, 3, 4})==10?"Pass":"Fail"); // Expected: 10
        System.out.println(solution(new int[]{-1, -1, 1, 1}) !=-1?"Pass":"Fail"); // Expected: Fail due to invalid values.

        // Interactive input.
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
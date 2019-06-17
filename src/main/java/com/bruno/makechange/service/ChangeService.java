package com.bruno.makechange.service;

import java.util.ArrayList;
import java.util.List;

/*
 * Class that calculates the minimum number of coins to give as change for the specific amount
 */
public class ChangeService {

    //fills the dynamic programming table with the minimum use of coins for each amount
    // of change up to the desired amount
    public int[][] buildTable(int[] coins, int amount) {

        int memo[][] = new int[coins.length][amount + 1];

        setUpTable(memo);

        for (int row = 1; row < memo.length; row++) {
            for (int col = 1; col < memo[0].length; col++) {
                if (coins[row] > col) {
                    memo[row][col] = memo[row - 1][col];
                } else {
                    memo[row][col] = Math.min(memo[row - 1][col],
                            memo[row][col - coins[row]] + 1);
                }
            }

        }

        return memo;
    }

    //based on the filled table, finds the coins used to give change
    public List<Integer> getCoinsUsedIn(int[][] memo, int[] coins) {

        List<Integer> coinsUsed = new ArrayList<Integer>();
        int row = memo.length - 1;
        int col = memo[0].length - 1;

        while (row != 0 && col != 0) {
            if (cameFromTop(memo[row][col], memo[row - 1][col])) {
                row--;
            } else {
                coinsUsed.add(coins[row]);
                col = col - coins[row];
            }
        }

        return coinsUsed;
    }

    //based on the filled table, gets the minimum number of coins used to give the desired change
    public int getMinCoinsUsed(int[][] table) {
        return table[table.length - 1][table[0].length - 1];
    }

    //inserts "infinite" values in the first row (where money used is zero)
    private void setUpTable(int[][] memo) {

        //put infitine in first row
        for (int i = 1; i < memo[0].length; i++) {
            memo[0][i] = Integer.MAX_VALUE;
        }

    }

    //verifies if number came from the top cell
    private static boolean cameFromTop(int current, int top) {
        if (current == top) {
            return true;
        } else {
            return false;
        }
    }

}

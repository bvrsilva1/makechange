package com.bruno.makechange.model;

import java.util.Arrays;
import java.util.List;

public class ResultChange {

    private List<Integer> coins;
    private int minNumberCoins;

    public ResultChange(int minCoinsUsed, List<Integer> coinsUsed) {
        this.minNumberCoins = minCoinsUsed;
        this.coins = coinsUsed;
    }

    public List<Integer> getCoins() {
        return coins;
    }

    public int getMinNumberCoins() {
        return minNumberCoins;
    }

    @Override
    public String toString() {
        return "Minimum number of coins used is " + minNumberCoins + "\n"
                + "Coins used: " + printCoins();
    }

    private String printCoins(){
        StringBuilder string = new StringBuilder();

        for(int coin : getCoins()){
            string.append("0."+ coin + " ");
        }

        return string.toString();
    }

}

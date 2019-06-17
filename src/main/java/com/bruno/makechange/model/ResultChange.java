package com.bruno.makechange.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Class represents the output to the user
 */
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
                + "Coins used: " + countFrequencyCoins();
    }

    //gets all used coins and count their frequency
    private String countFrequencyCoins(){

        Map<Integer, Integer> frequencyCoins = new HashMap<Integer, Integer>();

        StringBuilder string = new StringBuilder();

        for(int coin : getCoins()){
            if(frequencyCoins.containsKey(coin)){
                frequencyCoins.put(coin, frequencyCoins.get(coin) + 1);
            }
            else{
                frequencyCoins.put(coin, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : frequencyCoins.entrySet()){
            string.append(entry.getValue() + " coins of " + entry.getKey() + " cents, ");
        }

        return string.toString();
    }

}

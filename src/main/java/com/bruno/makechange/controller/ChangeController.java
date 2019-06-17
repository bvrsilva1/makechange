package com.bruno.makechange.controller;

import com.bruno.makechange.helper.ConversorHelper;
import com.bruno.makechange.model.ResultChange;
import com.bruno.makechange.service.ChangeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Class that proccess the input, calls the class responsible for calculating
 * minimum amount of coins to give as change and returns results to user (driver in this case)
 */

public class ChangeController {

    public ResultChange calculateChange(Set<String> coinsSet, String amountStr) {

        //convert amount (String) to integer
        int amount = ConversorHelper.convertStringToInt(amountStr);

        if(amount <= 0){
            return new ResultChange(0, new ArrayList<Integer>());
        }

        int[] coins = ConversorHelper.convertSetStringToInt(coinsSet);

        ChangeService changeService = new ChangeService();

        int[][] table = changeService.buildTable(coins, amount);
        int minCoinsUsed = changeService.getMinCoinsUsed(table);
        List<Integer> coinsUsed = changeService.getCoinsUsedIn(table, coins);

        ResultChange result = new ResultChange(minCoinsUsed, coinsUsed);

        return result;
    }

}

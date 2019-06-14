package com.bruno.makechange.controller;

import com.bruno.makechange.helper.ConversorHelper;
import com.bruno.makechange.model.ResultChange;
import com.bruno.makechange.service.ChangeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ChangeController {

    public ResultChange calculateChange(Set<String> coinsSet, String amountStr) {

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

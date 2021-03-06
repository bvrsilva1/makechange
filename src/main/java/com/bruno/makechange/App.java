package com.bruno.makechange;

import com.bruno.makechange.controller.ChangeController;
import com.bruno.makechange.model.ResultChange;

import java.util.HashSet;
import java.util.Set;

/*
 * Driver (App class) reads input arguments, does initial set up (coins to be used)
 * Calls the responsible for calculations
 * Prints results to user
 */

public class App {

    public static void main(String[] args) {

        String amountStr = args[0];

        //using a set to prevent repeated coins. ex: user inputs 0.05 but system already has coin 0.05,
        // set does not keep repeated numbers
        Set<String> coinsToBeUsed = new HashSet<String>();
        coinsToBeUsed.add(".0");
        coinsToBeUsed.add(".25");
        coinsToBeUsed.add(".10");
        coinsToBeUsed.add(".05");
        coinsToBeUsed.add(".01");

        for(int i = 1; i < args.length; i++){
            coinsToBeUsed.add(args[i]);
        }

        ChangeController changeController = new ChangeController();
        ResultChange result = changeController.calculateChange(coinsToBeUsed, amountStr);

        System.out.println(result);

    }

}

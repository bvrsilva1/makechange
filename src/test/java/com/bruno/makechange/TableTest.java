package com.bruno.makechange;

import com.bruno.makechange.controller.ChangeController;
import com.bruno.makechange.model.ResultChange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableTest {

    private Set<String> coins;
    private ChangeController changeController;

    @Before
    public void setUp(){
        coins = new HashSet<String>();
        coins.add(".0");
        coins.add(".25");
        coins.add(".10");
        coins.add(".05");
        coins.add(".01");

        changeController = new ChangeController();
    }

    @Test
    public void calculateExampleOneTest(){
        deleteSet();
        coins.add(".02");
        coins.add(".03");
        coins.add(".01");

        ResultChange result = changeController.calculateChange(coins, ".07");

        Assert.assertEquals(3, result.getMinNumberCoins());

        int resultCoins[] = {3, 2, 2};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleTwoTest(){
        deleteSet();
        coins.add(".02");
        coins.add(".03");
        coins.add(".01");

        ResultChange result = changeController.calculateChange(coins, ".05");

        Assert.assertEquals(2, result.getMinNumberCoins());

        int resultCoins[] = {3, 2};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleThreeTest(){
        deleteSet();
        coins.add(".02");
        coins.add(".03");
        coins.add(".01");

        ResultChange result = changeController.calculateChange(coins, ".04");

        Assert.assertEquals(2, result.getMinNumberCoins());

        int resultCoins[] = {2, 2};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleFourTest(){

        ResultChange result = changeController.calculateChange(coins, "4.10");

        Assert.assertEquals(17, result.getMinNumberCoins());

        int resultCoins[] = {25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 10};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleFiveTest(){

        ResultChange result = changeController.calculateChange(coins, "4.15");

        Assert.assertEquals(18, result.getMinNumberCoins());

        int resultCoins[] = {25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 10, 5};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleSixTest(){

        ResultChange result = changeController.calculateChange(coins, "4.50");

        Assert.assertEquals(18, result.getMinNumberCoins());

        int resultCoins[] = {25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleSevenTest(){

        ResultChange result = changeController.calculateChange(coins, "4.51");

        Assert.assertEquals(19, result.getMinNumberCoins());

        int resultCoins[] = {25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 1};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    @Test
    public void calculateExampleEightTest(){

        ResultChange result = changeController.calculateChange(coins, "4.56");

        Assert.assertEquals(20, result.getMinNumberCoins());

        int resultCoins[] = {25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 5, 1};
        Assert.assertArrayEquals(makeIntArray(result.getCoins()), resultCoins);

    }

    private int[] makeIntArray(List<Integer> coins) {
        int arr[] = new int[coins.size()];

        for(int i = 0; i < coins.size(); i++){
            arr[i] = coins.get(i);
        }

        return arr;
    }

    private void deleteSet() {
        coins.remove(".25");
        coins.remove(".10");
        coins.remove(".05");
        coins.remove(".01");
    }

}

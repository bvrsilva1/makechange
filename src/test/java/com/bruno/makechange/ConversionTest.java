package com.bruno.makechange;

import com.bruno.makechange.controller.ChangeController;
import com.bruno.makechange.helper.ConversorHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ConversionTest {

    private Set<String> coins;

    @Before
    public void setUp(){
        coins = new HashSet<String>();
        coins.add(".0");
        coins.add(".25");
        coins.add(".10");
        coins.add(".05");
        coins.add(".01");

    }

    @Test
    public void convertCoinsTest(){

        int answer[] = {0, 1, 5, 10, 25};

        Assert.assertArrayEquals(answer, ConversorHelper.convertSetStringToInt(coins));
    }

    @Test
    public void convertCoinsAddingRepeatedCoinsTest(){

        coins.add(".10");
        coins.add(".05");

        int answer[] = {0, 1, 5, 10, 25};

        Assert.assertArrayEquals(answer, ConversorHelper.convertSetStringToInt(coins));
    }

    @Test
    public void convertCoinsAddingNewCoinsTest(){

        coins.add("1.10");
        coins.add(".51");

        int answer[] = {0, 1, 5, 10, 25, 51, 110};

        Assert.assertArrayEquals(answer, ConversorHelper.convertSetStringToInt(coins));
    }

    @Test
    public void convertAmountEndingOneTest(){

        Assert.assertEquals(451, ConversorHelper.convertStringToInt("4.51"));
    }

    @Test
    public void convertAmountEndingZeroTest(){

        Assert.assertEquals(450, ConversorHelper.convertStringToInt("4.50"));
    }

    @Test
    public void convertAmountEndingFiveTest(){

        Assert.assertEquals(455, ConversorHelper.convertStringToInt("4.55"));
    }

    @Test
    public void convertAmountEndingSevenTest(){

        Assert.assertEquals(457, ConversorHelper.convertStringToInt("4.57"));
    }

    @Test
    public void convertAmountTenTenTest(){

        Assert.assertEquals(1010, ConversorHelper.convertStringToInt("10.10"));
    }

    @Test
    public void convertAmountElevenTest(){

        Assert.assertEquals(1100, ConversorHelper.convertStringToInt("11"));
    }

    @Test
    public void convertAmountElevenElevenZeroTest(){

        Assert.assertEquals(1111, ConversorHelper.convertStringToInt("11.11"));
    }

    @Test
    public void convertAmountFourTest(){

        Assert.assertEquals(400, ConversorHelper.convertStringToInt("4"));
    }

}

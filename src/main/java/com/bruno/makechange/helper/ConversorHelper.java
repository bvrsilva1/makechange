package com.bruno.makechange.helper;

import java.util.Arrays;
import java.util.Set;

public class ConversorHelper {

    private static final Double MULTIPLIER_FACTOR = new Double(10);

    public static int[] convertSetStringToInt(Set<String> set){

        int intArray[] = new int[set.size()];

        int index = 0;
        for(String str : set){
            intArray[index] = convert(new Double(str) * MULTIPLIER_FACTOR);
            index++;
        }

        //built in funciton that sorts the array using quicksort (sorting primitive array) -> O(n^2)
        //however takes less space (in-place sorting) than merge sort. quicksort operations are simpler than
        //mergesort and if a pivot is well chosen, it can be even faster than mergesort
        Arrays.sort(intArray);

        return intArray;
    }

    public static int convertStringToInt(String number){
        return convert(new Double(number) * MULTIPLIER_FACTOR);
        //return convert(new Double(number));
    }

    private static int convert(Double number){
        String doubleAsString = number.floatValue() + "";
        doubleAsString = doubleAsString.replaceAll("\\.","");
        int numberInteger = Integer.parseInt(doubleAsString);

        return numberInteger;
    }

}


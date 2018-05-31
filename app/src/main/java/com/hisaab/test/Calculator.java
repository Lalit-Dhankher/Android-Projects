package com.hisaab.test;

/**
 * Created by Lalit dhankher on 5/17/2018.
 */

public class Calculator {

    //add subtract divide multiply

    public int add(int a, int b) {

        int c = a + b;

        return c;
    }

    public int add(int[] vals){

        int length=vals.length;

        int sum=0;
        for (int i = 0; i < length; i++) {
            sum += vals[i];
        }

        return sum;
    }

    public int subtract(int a, int b){
        return a-b;
    }


    public int multiply(int a, int b){
        return a-b;
    }

    public int divide(int a, int b){
        return a-b;
    }

}

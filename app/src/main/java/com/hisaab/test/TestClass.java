package com.hisaab.test;

import android.util.Log;

/**
 * Created by Lalit dhankher on 5/17/2018.
 */

public class TestClass {


    public TestClass() {

        Cat cat = new Cat("red");

        Calculator calculator = new Calculator();

        int[] vals = {4, 10, 20};

        int result = calculator.add(vals);
        calculator.add(5, 10);

        calculator.divide(4, 10);

    }
}

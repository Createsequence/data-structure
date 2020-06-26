package com.huang.example.stack;

import org.junit.Test;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 11:52
 * @Description：<描述>
 */
public class StackCalculatorTest {

    @Test
    public void testCalculate() {
        String expression = "10*2*5/2+2*5-5";
        StackCalculator calculator = new StackCalculator();
        calculator.calculate(expression);
    }

}

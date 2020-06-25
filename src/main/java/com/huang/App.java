package com.huang;

import com.huang.example.stack.StackCalculator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        StackCalculator calculator = new StackCalculator();

        calculator.calculate("80*42*3-6+9/3-9");
    }
}

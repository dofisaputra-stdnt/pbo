package com.kuliahumb.pbo.pertemuan4;

public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.originalPrice = 20;
        calc.findTotal();

        calc.originalPrice = 25;
        calc.findTotal();
    }

}

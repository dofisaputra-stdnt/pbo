package com.kuliahumb.pbo.pertemuan4;

public class Calculator {

    double tip = .15;
    double tax = .5;
    double originalPrice = 10;

    public void findTotal() {
        double total = originalPrice + (originalPrice * tip) + (originalPrice * tax);
        System.out.println("Your total is " + total);
    }

}

package com.mavenproject.ch02.useInterface;

public class MyCalculator {
  public void calculate(int num1, int num2, ICalculator calculator) {
    double value = calculator.doOperation(num1, num2);
    System.out.println("value: " + value);
  }
}

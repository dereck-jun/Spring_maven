package com.calculator.ch02;

public class MyCalculator {
  public void calculate(int num1, int num2, ICalculator iCalculator) {
    int value = iCalculator.doOperation(num1, num2);
    System.out.println("result: " + value);
  }
}

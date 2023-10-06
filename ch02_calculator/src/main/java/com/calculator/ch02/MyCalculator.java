package com.calculator.ch02;

public class MyCalculator {
  public void calAdd(int num1, int num2) {
    ICalculator calculator = new CalAdd();
    int value = calculator.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calSub(int num1, int num2) {
    ICalculator calculator = new CalSub();
    int value = calculator.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calMul(int num1, int num2) {
    ICalculator calculator = new CalMul();
    int value = calculator.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calDiv(int num1, int num2) {
    ICalculator calculator = new CalDiv();
    int value = calculator.doOperation(num1, num2);
    System.out.println("result: " + value);
  }
}

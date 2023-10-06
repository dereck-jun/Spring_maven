package com.calculator.ch02;

public class MyCalculator {
  public void calAdd(int num1, int num2, CalAdd add) { // 객체 주입 (DI)
    int value = add.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calSub(int num1, int num2, CalSub sub) {
    int value = sub.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calMul(int num1, int num2, CalMul mul) {
    int value = mul.doOperation(num1, num2);
    System.out.println("result: " + value);
  }

  public void calDiv(int num1, int num2, CalDiv div) {
    int value = div.doOperation(num1, num2);
    System.out.println("result: " + value);
  }
}

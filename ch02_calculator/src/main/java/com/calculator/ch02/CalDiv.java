package com.calculator.ch02;

public class CalDiv implements ICalculator {
  @Override
  public int doOperation(int Num1, int Num2) {
    if (Num1 != 0 && Num2 != 0) {
      return Num1 / Num2;
    } else {
      return 0;
    }
  }
}

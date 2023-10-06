package com.calculator.ch02;

public class CalAdd implements ICalculator {
  @Override
  public int doOperation(int Num1, int Num2) {
    return Num1 + Num2;
  }
}

package com.mavenproject.ch02.useIoC;

public class Sub implements ICalculator {
  @Override
  public int doOperation(int num1, int num2) {
    return num1 - num2;
  }
}
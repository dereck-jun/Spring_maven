package com.mavenproject.ch02;

public class Div implements ICalculator{
  @Override
  public int doOperation(int num1, int num2) {
    return (num1 != 0) && (num2 != 0) ? num1 / num2 : -1;
  }
}
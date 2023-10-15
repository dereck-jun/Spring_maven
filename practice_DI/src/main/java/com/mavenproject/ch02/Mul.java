package com.mavenproject.ch02;

public class Mul implements ICalculator{
  @Override
  public int doOperation(int num1, int num2) {
    return num1 * num2;
  }
}
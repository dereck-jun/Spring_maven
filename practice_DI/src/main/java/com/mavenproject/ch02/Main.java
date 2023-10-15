package com.mavenproject.ch02;

public class Main {
  public static void main(String[] args) {
    MyCalculator calculator = new MyCalculator();
    calculator.calculate(10, 5, new Add());
  }
}
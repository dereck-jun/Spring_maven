package com.calculator.ch02;

public class MainClass {
  public static void main(String[] args) {
    MyCalculator calculator = new MyCalculator();
    // CalAdd 를 외부에서 주입 -> MyCalculator 는 연산에 필요한 객체를 직접 생성하지 않고 외부에서 받아서 사용
    calculator.calAdd(10, 5, new CalAdd());
    calculator.calSub(10, 5, new CalSub());
    calculator.calMul(10, 5, new CalMul());
    calculator.calDiv(10, 5, new CalDiv());
  }
}
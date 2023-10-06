package com.calculator.ch02;

public class CalAssembler {
  MyCalculator calculator;
  CalAdd add;
  CalSub sub;
  CalMul mul;
  CalDiv div;

  public CalAssembler() {
    calculator = new MyCalculator();
    add = new CalAdd();
    sub = new CalSub();
    mul = new CalMul();
    div = new CalDiv();

    assemble();
  }

  private void assemble() {
    calculator.calculate(10, 5, add);
    calculator.calculate(10, 5, sub);
    calculator.calculate(10, 5, mul);
    calculator.calculate(10, 5, div);
  }
}

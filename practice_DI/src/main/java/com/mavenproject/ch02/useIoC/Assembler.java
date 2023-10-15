package com.mavenproject.ch02.useIoC;

public class Assembler {
  Add add;
  Sub sub;
  Mul mul;
  Div div;
  MyCalculator calculator;

  public Assembler(Add add, Sub sub, Mul mul, Div div, MyCalculator calculator) {
    this.add = add;
    this.sub = sub;
    this.mul = mul;
    this.div = div;
    this.calculator = calculator;
  }

  public void calculate(int num1, int num2, String aOperator){
    switch (aOperator){
      case "+":
        calculator.calculate(num1, num2, add);
        break;
      case "-":
        calculator.calculate(num1, num2, sub);
        break;
      case "*":
        calculator.calculate(num1, num2, mul);
        break;
      case "/":
        calculator.calculate(num1, num2, div);
        break;
    }
  }
}

package com.mavenproject.ch02.useIoC;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
    Assembler assembler = ctx.getBean("cAssembler", Assembler.class);
    Scanner scan = new Scanner(System.in);
    int num1 = 0, num2 = 0;
    String aOperator;

    System.out.print("첫 번째 정수 입력: ");
    num1 = scan.nextInt();
    System.out.print("두 번째 정수 입력: ");
    num2 = scan.nextInt();
    System.out.print("연산 기호 입력: ");
    aOperator = scan.next();

    assembler.calculate(num1, num2, aOperator);




  }
}
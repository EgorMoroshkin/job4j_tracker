package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return x - a;
    }

    public  int divide(int a) {
        return a / x;
    }

    public  int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int rslSum = Calculator.sum(10);
        System.out.println(rslSum);
        Calculator calculatorMultiply = new Calculator();
        int rslMultiply = calculatorMultiply.multiply(5);
        System.out.println(rslMultiply);
        int rslMinus = minus(10);
        System.out.println(rslMinus);
        Calculator calculatorDivide = new Calculator();
        int rslDivide = calculatorDivide.divide(10);
        System.out.println(rslDivide);
        System.out.println();
        Calculator calculatorSumAllOperation = new Calculator();
        int rslSumAllOperation = calculatorSumAllOperation.sumAllOperation(20);
        System.out.println(rslSumAllOperation);
    }
}

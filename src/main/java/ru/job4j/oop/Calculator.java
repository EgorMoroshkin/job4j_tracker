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
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int rslSum = Calculator.sum(10);
        System.out.println(rslSum);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(5);
        System.out.println(rslMultiply);
        int rslMinus = minus(10);
        System.out.println(rslMinus);
        int rslDivide = calculator.divide(10);
        System.out.println(rslDivide);
        System.out.println();
        int rslSumAllOperation = calculator.sumAllOperation(20);
        System.out.println(rslSumAllOperation);
    }
}

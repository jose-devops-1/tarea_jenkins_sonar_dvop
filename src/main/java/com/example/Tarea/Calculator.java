package com.example;

public class Calculator {

    // Método principal que recibe 2 números y un operador
    public static double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("No se puede dividir por cero");
                }
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Operador no válido: " + operator);
        }
    }

    // Operaciones básicas
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    // Método main para probar
    public static void main(String[] args) {
        System.out.println("2 + 3 = " + calculate(2, 3, '+'));
        System.out.println("10 - 5 = " + calculate(10, 5, '-'));
        System.out.println("4 * 6 = " + calculate(4, 6, '*'));
        System.out.println("20 / 4 = " + calculate(20, 4, '/'));
    }
}
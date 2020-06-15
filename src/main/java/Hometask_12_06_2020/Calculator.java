package Hometask_12_06_2020;

public class Calculator {
    Calculator(){}

    public int sum(int a, int b) {
        int result = a + b;
        System.out.println("Result of operation is: " + result);
        return result;
    }

    public int min(int a, int b) {
        int result = a - b;
        System.out.println("Result of operation is: " + result);
        return result;
    }

    public int dev(int a, int b) {
        int result = a / b;
        System.out.println("Result of operation is: " + result);
        return result;
    }

    public int mul(int a, int b) {
        int result = a * b;
        System.out.println("Result of operation is: " + result);
        return result;
    }

    public int manyActions(int a, int b) {
        int result = a * b + 10;
        System.out.println("Result of operation is: " + result);
        return result;
    }
}

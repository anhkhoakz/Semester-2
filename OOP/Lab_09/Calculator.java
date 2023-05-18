import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number a: ");
        int a = sc.nextInt();
        System.out.print("Enter number b: ");
        int b = sc.nextInt();

        sc.close();

        Calculator cal = new Calculator();

        try {
            double divide_res = cal.divide(a, b);
            System.out.println("Divide result: " + divide_res);
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (NumberOutOfRangeException e) {
            System.err.println(e.getMessage());
        }

        try {
            int multiply_res = cal.multiply(a, b);
            System.out.println("Multiply result: " + multiply_res);
        } catch (NumberOutOfRangeException e) {
            System.err.println(e.getMessage());
        }
    }

    public double divide(int a, int b) throws ArithmeticException, NumberOutOfRangeException {
        if (b < 0) {
            throw new ArithmeticException("Divide by Zero");
        } else if (a > 1000 || b > 1000 || a < -1000 || b < -1000) {
            throw new NumberOutOfRangeException("Number is outside the computation");
        } else {
            return (double) a / (double) b;
        }
    }

    public int multiply(int a, int b) throws NumberOutOfRangeException {
        if (a > 1000 || b > 1000 || a < -1000 || b < -1000) {
            throw new NumberOutOfRangeException("Number is outside the computation");
        } else {
            return a * b;
        }
    }

    class NumberOutOfRangeException extends Exception {
        public NumberOutOfRangeException() {
            super();
        }

        public NumberOutOfRangeException(String s) {
            super(s);
        }
    }
}

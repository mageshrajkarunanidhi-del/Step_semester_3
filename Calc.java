public class Calc {
    public static void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

    public static void main(String[] args) {
        calculate(10, 4, '+'); // Expected: Result: 14.0
        calculate(10, 0, '/'); // Expected: Cannot divide by zero
        calculate(10, 4, '%'); // Expected: Invalid operator
    }
}


import java.util.Scanner;

interface Customer {
    double calculateAmount(double amount);
}

class Student implements Customer {
    @Override
    public double calculateAmount(double amount) {
        return amount * 0.90;
    }
}

class Staff implements Customer {
    @Override
    public double calculateAmount(double amount) {
        return amount * 0.95;
    }
}

class Guest implements Customer {
    @Override
    public double calculateAmount(double amount) {
        return amount + 10;
    }
}

class CustomerFactory {
    public static Customer createCustomer(String type) {
        return switch (type) {
            case "STUDENT" -> new Student();
            case "STAFF" -> new Staff();
            case "GUEST" -> new Guest();
            default -> throw new IllegalArgumentException("Invalid customer type");
        };
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();

                Customer customer = CustomerFactory.createCustomer(type);

                double finalAmount = customer.calculateAmount(amount);

                System.out.printf("%s: %.2f%n", type, finalAmount);

                total += finalAmount;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
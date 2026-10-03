import java.util.*;

interface PaymentMethod {
    double calculateAmount(double amount);
}

class CardPayment implements PaymentMethod {
    @Override
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements PaymentMethod {
    @Override
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransferPayment implements PaymentMethod {
    @Override
    public double calculateAmount(double amount) {
        return amount;
    }
}

class PaymentFactory {
    public static PaymentMethod create(String type) {
        return switch (type) {
            case "CARD" -> new CardPayment();
            case "WALLET" -> new WalletPayment();
            case "BANKTRANSFER" -> new BankTransferPayment();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                double amount = sc.nextDouble();

                PaymentMethod payment = PaymentFactory.create(type);
                double adjustedAmount = payment.calculateAmount(amount);

                System.out.printf("%s: %.2f%n", type, adjustedAmount);
                total += adjustedAmount;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
import java.util.*;

interface Delivery {
    double calculateFee();
}

class StandardDelivery implements Delivery {
    private final double weight;
    private final double distance;

    StandardDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    @Override
    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery implements Delivery {
    private final double weight;
    private final double distance;

    ExpressDelivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    @Override
    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery implements Delivery {
    private final double weight;
    private final double distance;
    private final double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight;
        this.distance = distance;
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25
                + (2.00 * weight)
                + (0.50 * distance)
                + customsFee;
    }
}

class DeliveryFactory {
    public static Delivery create(String[] parts) {
        String type = parts[0];

        return switch (type) {
            case "STANDARD" ->
                    new StandardDelivery(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2])
                    );

            case "EXPRESS" ->
                    new ExpressDelivery(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2])
                    );

            case "INTERNATIONAL" ->
                    new InternationalDelivery(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])
                    );

            default -> throw new IllegalArgumentException("Invalid delivery type");
        };
    }
}

public class Main3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;

            for (int i = 0; i < n; i++) {
                String[] parts = sc.nextLine().trim().split(" ");

                // Handles the newline after nextInt()
                if (parts.length == 1) {
                    parts = sc.nextLine().trim().split(" ");
                }

                String type = parts[0];

                Delivery delivery = DeliveryFactory.create(parts);

                double fee = delivery.calculateFee();

                System.out.printf("%s: %.2f%n", type, fee);

                total += fee;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
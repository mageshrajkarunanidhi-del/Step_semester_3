import java.util.*;

interface Transport {
    double calculateFare();
}

class Bus implements Transport {
    private final double distance;

    Bus(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateFare() {
        double fare = 2 + (0.10 * distance);

        return Math.min(fare, 10);
    }
}

class Train implements Transport {
    private final double distance;

    Train(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro implements Transport {
    private final double distance;
    private final double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        this.distance = distance;
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        double fare = 1.50 + (0.20 * distance);

        return fare * peakHourFactor;
    }
}

class TransportFactory {
    public static Transport create(String[] parts) {

        String type = parts[0];

        return switch (type) {
            case "BUS" ->
                    new Bus(Double.parseDouble(parts[1]));

            case "TRAIN" ->
                    new Train(Double.parseDouble(parts[1]));

            case "METRO" ->
                    new Metro(
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2])
                    );

            default ->
                    throw new IllegalArgumentException("Invalid transport type");
        };
    }
}

public class Main5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            double total = 0;

            for (int i = 0; i < n; i++) {

                String[] parts = sc.nextLine().split(" ");

                String type = parts[0];

                Transport transport = TransportFactory.create(parts);

                double fare = transport.calculateFare();

                System.out.printf("%s: %.2f%n", type, fare);

                total += fare;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
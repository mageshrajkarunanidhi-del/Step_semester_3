import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
}

class Bike implements Vehicle {
    private final int hours;

    public Bike(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateCharge() {
        return hours * 10;
    }
}

class Car implements Vehicle {
    private final int hours;

    public Car(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    private final int hours;

    public Truck(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateCharge() {
        return Math.max(hours * 50, 100);
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type, int hours) {
        return switch (type) {
            case "BIKE" -> new Bike(hours);
            case "CAR" -> new Car(hours);
            case "TRUCK" -> new Truck(hours);
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }
}

public class CampusParkingCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int hours = sc.nextInt();

                Vehicle vehicle = VehicleFactory.createVehicle(type, hours);

                double charge = vehicle.calculateCharge();

                System.out.printf("%s: %.2f%n", type, charge);

                total += charge;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
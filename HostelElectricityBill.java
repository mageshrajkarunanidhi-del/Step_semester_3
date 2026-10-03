import java.util.Scanner;

interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    private final int units;

    public SingleRoom(int units) {
        this.units = units;
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom implements Room {
    private final int units;
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6) / occupants;
    }
}

class ACRoom implements Room {
    private final int units;

    public ACRoom(int units) {
        this.units = units;
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }
}

class RoomFactory {
    public static Room createRoom(String type, int units, int occupants) {
        return switch (type) {
            case "SINGLE" -> new SingleRoom(units);
            case "SHARED" -> new SharedRoom(units, occupants);
            case "AC" -> new ACRoom(units);
            default -> throw new IllegalArgumentException("Invalid room type");
        };
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            double total = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int units = sc.nextInt();

                int occupants = 0;

                if (type.equals("SHARED")) {
                    occupants = sc.nextInt();
                }

                Room room = RoomFactory.createRoom(type, units, occupants);

                double bill = room.calculateBill();

                System.out.printf("%s: %.2f%n", type, bill);

                total += bill;
            }

            System.out.printf("Total: %.2f%n", total);
        }
    }
}
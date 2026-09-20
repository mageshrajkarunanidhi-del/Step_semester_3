public class Piggybank {
    private double savings;
    private final String id;

    public Piggybank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

@SuppressWarnings("unused")
class Main {
    public static void main(String[] args) {
        Piggybank pb = new Piggybank("PB-1");

        pb.deposit(100);
        System.out.println(pb.getSavings()); // 100

        pb.withdraw(30);
        System.out.println(pb.getSavings()); // 70

        pb.withdraw(500);
        System.out.println(pb.getSavings()); // 70
    }
}

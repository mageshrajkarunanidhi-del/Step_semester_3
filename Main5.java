import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Plan {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan plan;

            switch (type) {
                case "BASIC":
                    plan = new Basic(name, date);
                    break;
                case "STANDARD":
                    plan = new Standard(name, date);
                    break;
                default:
                    plan = new Premium(name, date);
            }

            System.out.println(
                plan.name + ": " + plan.calculateRenewalDate()
            );
        }

        sc.close();
    }
}
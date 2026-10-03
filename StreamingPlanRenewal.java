import java.time.LocalDate;
import java.util.Scanner;

interface StreamingPlan {
    LocalDate calculateRenewalDate(LocalDate startDate);
}

class BasicPlan implements StreamingPlan {
    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class StandardPlan implements StreamingPlan {
    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class PremiumPlan implements StreamingPlan {
    @Override
    public LocalDate calculateRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

class PlanFactory {
    public static StreamingPlan createPlan(String type) {
        return switch (type) {
            case "BASIC" -> new BasicPlan();
            case "STANDARD" -> new StandardPlan();
            case "PREMIUM" -> new PremiumPlan();
            default -> throw new IllegalArgumentException("Invalid plan type");
        };
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                String dateString = sc.next();

                LocalDate startDate = LocalDate.parse(dateString);

                StreamingPlan plan = PlanFactory.createPlan(type);

                LocalDate renewalDate =
                        plan.calculateRenewalDate(startDate);

                System.out.printf("%s: %s%n", name, renewalDate);
            }
        }
    }
}
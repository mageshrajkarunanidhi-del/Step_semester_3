import java.util.Scanner;

interface Employee {
    double calculateBonus();
    
    String getName();
}

class FullTimeEmployee implements Employee {
    private final String name;
    private final double salary;

    public FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements Employee {
    private final String name;
    private final double salary;

    public PartTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Intern implements Employee {
    private final String name;

    public Intern(String name, double salary) {
        this.name = name;
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }

    @Override
    public String getName() {
        return name;
    }
}

class EmployeeFactory {
    public static Employee createEmployee(
            String type,
            String name,
            double salary) {

        switch (type) {
            case "FULLTIME" -> {
                return new FullTimeEmployee(name, salary);
            }
            case "PARTTIME" -> {
                return new PartTimeEmployee(name, salary);
            }
            case "INTERN" -> {
                return new Intern(name, salary);
            }
            default -> throw new IllegalArgumentException("Invalid employee type");
        }
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            double totalBonus = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                String name = sc.next();
                double salary = sc.nextDouble();

                Employee employee =
                        EmployeeFactory.createEmployee(type, name, salary);

                double bonus = employee.calculateBonus();

                System.out.printf("%s: %.2f%n",
                        employee.getName(), bonus);

                totalBonus += bonus;
            }

            System.out.printf("Total Bonus: %.2f%n", totalBonus);
        }
    }
}
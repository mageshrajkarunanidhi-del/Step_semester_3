class Employee {
    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5 {
    public static void main(String[] args) {

        Employee e1 = new Employee("Ravi", 50000);
        Employee e2 = new Employee("Priya", 55000);
        Employee e3 = new Employee("Arjun", 45000);

        System.out.println("Employee details: " + e1.empName + ", Salary: " + e1.salary);
        System.out.println("Employee details: " + e2.empName + ", Salary: " + e2.salary);
        System.out.println("Employee details: " + e3.empName + ", Salary: " + e3.salary);
        Employee.printCompanyInfo();
    }
}
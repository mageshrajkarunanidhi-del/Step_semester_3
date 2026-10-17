
import java.util.Locale;
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / 3.0;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void displayResult() {
        System.out.printf(
            Locale.US,
            "%s: Average %.1f, Grade %c%n",
            name.toUpperCase(),
            calculateAverage(),
            calculateGrade()
        );
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();

            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            Student student = new Student(name, marks);
            student.displayResult();
        }

        sc.close();
    }
}

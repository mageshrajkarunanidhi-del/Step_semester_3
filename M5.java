class Student {
    String name;
    double attendance;

    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Attendance: " + attendance + "%");
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5 {
    public static void main(String[] args) {

        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Anitha", 90.0);

        s1.printStudentInfo();
        s2.printStudentInfo();
        Student.printCollegeInfo();
    }
}
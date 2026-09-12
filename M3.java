class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public String getTitle() {
        return title;
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

public class M3 {
    public static void main(String[] args) {

        Course theory = new Course(
            "21CSC201J",
            "Data Structures",
            4
        );

        Course lab = new Course(
            "21CSC205L",
            "DSA Lab",
            3,
            1
        );

        System.out.println(
            theory.code + " (" + theory.getTitle() + ") total credits: " + theory.totalCredits()
        );

        System.out.println(
            lab.code + " (" + lab.getTitle() + ") total credits: " + lab.totalCredits()
        );
    }
}

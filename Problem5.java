import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;


    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }


    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }


    public double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }


    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }
}


public class Problem5 {

    // CGPA-only eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }


    // Borderline CGPA + coding score eligibility
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }


    static String shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        // Count eligible candidates
        for (Candidate candidate : candidates) {

            if (
                isEligible(candidate.getCgpa()) ||
                isEligible(
                    candidate.getCgpa(),
                    candidate.getCodingScore()
                )
            ) {
                count++;
            }
        }


        // Create shortlisted array
        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (
                isEligible(candidate.getCgpa()) ||
                isEligible(
                    candidate.getCgpa(),
                    candidate.getCodingScore()
                )
            ) {

                shortlisted[index] = candidate;
                index++;
            }
        }


        // Uses Candidate.compareTo()
        Arrays.sort(shortlisted);


        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {

            if (i > 0) {
                result.append(" | ");
            }

            result
                .append(i + 1)
                .append(". ")
                .append(shortlisted[i].getName())
                .append(" (")
                .append(shortlisted[i].getCompositeScore())
                .append(")");
        }

        return result.toString();
    }


    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),

            new Candidate("Rohit", 6.8, 65),

            new Candidate("Meena", 6.0, 90),

            new Candidate("Karan", 7.5, 20)
        };


        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}
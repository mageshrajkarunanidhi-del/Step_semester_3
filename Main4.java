import java.util.*;

interface Question {
    double evaluate();
}

class MCQQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    MCQQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TFQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    TFQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final double points;

    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");

        String answer = studentAnswer.toLowerCase();

        int matched = 0;

        for (String keyword : keywords) {
            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

class QuestionFactory {
    public static Question create(
            String type,
            String correctAnswer,
            String studentAnswer,
            double points) {

        return switch (type) {
            case "MCQ" ->
                    new MCQQuestion(correctAnswer, studentAnswer, points);

            case "TF" ->
                    new TFQuestion(correctAnswer, studentAnswer, points);

            case "ESSAY" ->
                    new EssayQuestion(correctAnswer, studentAnswer, points);

            default ->
                    throw new IllegalArgumentException("Invalid question type");
        };
    }
}

public class Main4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());

            double total = 0;

            for (int i = 0; i < n; i++) {

                String line = sc.nextLine();

                // Split input while keeping quoted strings together
                List<String> parts = new ArrayList<>();

                java.util.regex.Matcher matcher =
                        java.util.regex.Pattern
                                .compile("\"([^\"]*)\"|(\\S+)")
                                .matcher(line);

                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        parts.add(matcher.group(1));
                    } else {
                        parts.add(matcher.group(2));
                    }
                }

                String type = parts.get(0);
                String correctAnswer = parts.get(2);
                String studentAnswer = parts.get(3);
                double points = Double.parseDouble(parts.get(4));

                Question question = QuestionFactory.create(
                        type,
                        correctAnswer,
                        studentAnswer,
                        points
                );

                double score = question.evaluate();

                System.out.printf("%s: %.2f%n", type, score);

                total += score;
            }

            System.out.printf("Total Score: %.2f%n", total);
        }
    }
}

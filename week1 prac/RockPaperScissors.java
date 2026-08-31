import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        // Sample player moves for 5 rounds
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int totalRounds = playerMoves.length;

        int wins = 0, losses = 0, draws = 0;

        System.out.printf("%-8s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            switch (result) {
                case "Player Wins" -> wins++;
                case "Computer Wins" -> losses++;
                default -> draws++;
            }

            System.out.printf("%-8d %-15s %-15s %-15s%n", (i + 1), playerMove, computerMove, result);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;

        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}

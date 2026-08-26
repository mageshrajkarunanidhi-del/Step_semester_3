public class GuessTheNumberGame {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessedCorrectly = false;

        while (tries < maxTries && tries < guesses.length) {
            int currentGuess = guesses[tries];
            tries++;

            if (currentGuess < secretNumber) {
                System.out.println("Too low");
            } else if (currentGuess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Correct! You guessed it");
                guessedCorrectly = true;
                break;
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Out of tries the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        int[] guesses1 = {20, 60, 42};
        guessTheNumber(42, 4, guesses1);

        System.out.println("---");

        int[] guesses2 = {10, 15};
        guessTheNumber(42, 2, guesses2);
    }
}
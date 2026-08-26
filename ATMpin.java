public class ATMpin {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int attemptCount = 0;
        boolean isAccepted = false;
        int maxAttempts = 3;

        // Loop continues while attempts remain and PIN is not yet accepted
        while (attemptCount < attempts.length && attemptCount < maxAttempts && !isAccepted) {
            if (attempts[attemptCount].equals(correctPin)) {
                isAccepted = true;
                System.out.println("PIN accepted");
                break;
            }
            attemptCount++;
        }

        if (!isAccepted) {
            System.out.println("Card blocked too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        String[] attempts1 = {"1111", "4821"};
        atmPinRetry("4821", attempts1);

        String[] attempts2 = {"1111", "2222", "3333"};
        atmPinRetry("4821", attempts2);
    }
}
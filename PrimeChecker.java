
import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            boolean prime = num > 1;

            for (int i = 2; i * i <= num && prime; i++) {
                if (num % i == 0) {
                    prime = false;
                }
            }

            if (prime) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        }

        sc.close();
    }
}

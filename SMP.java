public class SMP {
    public static void printSkippingMultiplesOfThree() {
        for (int i = 1; i <= 20; i++) {
            // Check if current number is a multiple of 3
            if (i % 3 == 0) {
                continue; // Skip printing and go directly to next iteration
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printSkippingMultiplesOfThree();
    }
}

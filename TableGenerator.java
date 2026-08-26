public class TableGenerator {
    public static void generateFirstValidTable(int[] candidates) {
        for (int num : candidates) {
            // Skip invalid candidates (less than 1)
            if (num < 1) {
                System.out.println("Skipping invalid number: " + num);
                continue;
            }

            // Print table for the first valid candidate found
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }

            // Stop processing further candidates once a valid table is printed
            break;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {-3, 0, 7, 9};
        generateFirstValidTable(candidates);
    }
}
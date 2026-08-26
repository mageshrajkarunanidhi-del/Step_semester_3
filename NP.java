public class NP {
    public static void printNumberPyramid(int n) {
        // Outer loop for each row from 1 to n
        for (int i = 1; i <= n; i++) {
            // Inner loop prints the row number 'i' times on the same line
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            // Move to the next line after completing the row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printNumberPyramid(4);
    }
}
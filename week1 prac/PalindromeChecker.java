public class PalindromeChecker {

    // 1. Iterative Approach
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2. Recursive Approach
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array Reversal Approach
    public static boolean isPalindromeArrayReversal(String text) {
        char[] charArray = text.toCharArray();
        char[] reversedArray = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            reversedArray[i] = charArray[charArray.length - 1 - i];
        }

        return new String(charArray).equals(new String(reversedArray));
    }

    public static void checkPalindrome(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        System.out.println("\"" + text + "\"");
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                iter ? "Palindrome" : "Not Palindrome",
                recur ? "Palindrome" : "Not Palindrome",
                rev ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        checkPalindrome("madam");
        checkPalindrome("hello");
    }
}

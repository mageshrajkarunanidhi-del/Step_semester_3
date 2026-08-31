import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count character frequencies
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Scan left-to-right for first character with frequency 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // Return null char if no unique character exists
    }

    public static void testNonRepeating(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.println("Input: \"" + text + "\"");
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'\n");
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        testNonRepeating("swiss");
        testNonRepeating("aabbcc");
    }
}

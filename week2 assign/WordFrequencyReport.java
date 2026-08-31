import java.util.*;

public class WordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Clean punctuation and normalize case
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        // Count frequencies of non-stop words
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print frequency report
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
import java.util.Map;

public class CharFrequencyCounter {
    public static java.util.HashMap<Character, Integer> countCharFrequency(String input) {
        java.util.HashMap<Character, Integer> frequencyMap = new java.util.HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        String input = "hello World";
        java.util.HashMap<Character, Integer> result = countCharFrequency(input);
        System.out.println("Character Frequencies in \"" + input + "\":");
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            System.out.println("'" + entry.getKey() + "':" + entry.getValue());
        }
    }
}

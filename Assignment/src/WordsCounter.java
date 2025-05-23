public class WordsCounter {
    public static int countWords(String input) {
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        String input = "Hello world this is a test";
        int result = countWords(input);
        System.out.println("Input: \"" + input + "\" has " + result + " words");

    }
}

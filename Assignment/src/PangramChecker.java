import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PangramChecker {
    public static boolean isPangram(String sentence) {
        Set<Character> uniqueLetters = new HashSet<>();

        for (char c: sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                uniqueLetters.add(c);
            }
        }

        return uniqueLetters.size() ==26;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence to check if it's a pangram: ");
        String sentence = scanner.nextLine();

        if (isPangram(sentence)) {
            System.out.println("\"" + sentence + "\" is a pangram!");
        } else {
            System.out.println("\"" + sentence + "\" is not a pangram.");
        }

        scanner.close();
    }
}

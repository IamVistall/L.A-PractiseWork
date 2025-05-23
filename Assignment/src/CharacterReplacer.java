import java.util.Scanner;

public class CharacterReplacer {
    public static String replaceCharacter(String input, char oldChar, char newChar) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.replace(oldChar, newChar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a String: ");
        String inputString = scanner.nextLine();

        System.out.println("Enter the character to replace: ");
        char oldChar = scanner.nextLine().charAt(0);

        System.out.println("Enter the replacement character: ");
        char newChar = scanner.nextLine().charAt(0);

        String result = replaceCharacter(inputString, oldChar, newChar);
        System.out.println("Modified string: " + result);
        scanner.close();
    }
}

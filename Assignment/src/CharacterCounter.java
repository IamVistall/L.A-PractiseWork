import java.util.Scanner;

public class CharacterCounter {
    public static int countChar(String str, char ch) {
        int count = 0;
        str = str.toLowerCase();
        ch = Character.toLowerCase(ch);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count ++;
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.println("Enter a character: ");
        char inputCharacter = scanner.next().charAt(0);

        int result = countChar(inputString,inputCharacter);

        System.out.println("The character '" + inputCharacter + "' appears " + result + "time(s) in the string.");
        scanner.close();
    }
}

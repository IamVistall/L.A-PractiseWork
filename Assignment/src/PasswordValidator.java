import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5;
        int attempt = 0;
        boolean isValid = false;

        while (attempt < maxAttempts && !isValid) {
            attempt++;
            System.out.println("Enter Your password: ");
            String password = scanner.nextLine();

            String[] result = validatePassword(password);
            System.out.println(result[1]);

            if (result[0].equals("true")) {
                isValid = true;
            } else {
                int remaining = maxAttempts - attempt;
                if (remaining > 0) {
                    System.out.println("You have " + remaining + " attempt(s) remaining.");
                }
            }
        }
        if (!isValid) {
            System.out.println("Maximum attempts reached. Cannot try again.");
        }
        scanner.close();
    }

    public static String[] validatePassword(String password) {
        List<String> reasons = new ArrayList<>();
        if (password.length() < 8) {
            reasons.add("password too short");
        }
        boolean hasUpper = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
                break;
            }
        }
        if (!hasUpper) {
            reasons.add("no upper case character");
        }

        boolean hasLower = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
                break;
            }
        }
        if (!hasLower) {
            reasons.add("no lower case character");
        }

        boolean hasNumber = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            reasons.add("no number");
        }
        if (reasons.isEmpty()) {
            return new String[] {"true", "Password is valid"};
        }else {
            return new String[] {"false", String.join(", ", reasons)};
        }

    }
}

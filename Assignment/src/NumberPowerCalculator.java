import java.util.Scanner;

public class NumberPowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a base Number: ");
        double base = scanner.nextDouble();
        System.out.println("Enter the exponent: ");
        int exponent = scanner.nextInt();

        double result = 1.0;
        int absExponent = Math.abs(exponent);
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1.0 / result;
        }

        System.out.printf("%.2f raised to the power of %d is: %.2f%n", base, exponent, result);
         scanner.close();
    }
}

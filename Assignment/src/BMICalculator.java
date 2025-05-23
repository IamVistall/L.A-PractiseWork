import java.util.Scanner;
public class BMICalculator {
    public static double calculateBMI(double weightKg, double heightM) {
         return weightKg / (heightM * heightM);
    }

    public static String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if ( bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the BMI Calculator");

        while (true) {
            System.out.println("Enter height in meters (or 'stop' to quit): ");
            String heightInput = scanner.nextLine();

            if (heightInput.equalsIgnoreCase("stop")) {
                System.out.println("Exiting BMI calculator.");
                break;
            }

            Scanner heightScanner = new Scanner(heightInput);
            if (!heightScanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value for height.");
                continue;
            }
            double heightM = heightScanner.nextDouble();
            if (heightM <= 0) {
                System.out.println("Height must be positive. Try again.");
                continue;
            }
            System.out.print("Enter weight in kilograms: ");
            String weightInput = scanner.nextLine();

            Scanner weightScanner = new Scanner(weightInput);
            if (!weightScanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value for weight.");
                continue;
            }
            double weightKg = weightScanner.nextDouble();
            if (weightKg <= 0) {
                System.out.println("Weight must be positive. Try again.");
                continue;
            }
            double bmi = calculateBMI(weightKg, heightM);
            String category = getBMICategory(bmi);

            System.out.printf("\nYour BMI is: %.1f|n", bmi);
            System.out.println("Category: "+ category + "\n");
        }
        scanner.close();
    }

}


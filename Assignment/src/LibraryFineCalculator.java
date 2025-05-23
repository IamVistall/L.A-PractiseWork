import  java.util.Scanner;
public class LibraryFineCalculator {
    public static double CalculateFine (int daysOverdue){
        double fine = 0.0;
        if (daysOverdue <= 7) {
            fine = daysOverdue * 0.50;
        } else if (daysOverdue <= 14) {
            fine = (7 * 0.50) + ((daysOverdue - 7) * 1.0);
        } else {
            fine = (7 * 0.50) + (7 * 1.0) + ((daysOverdue - 14) * 5.0);
        }
        return fine;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Number of days this book is overdue: ");
        int daysOverdue = scanner.nextInt();

        double totalFine = CalculateFine(daysOverdue);
        System.out.printf("Total fine: $%.2f\n", totalFine);

        scanner.close();
    }
}

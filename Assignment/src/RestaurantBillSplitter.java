import java.util.Scanner;

public class RestaurantBillSplitter {
    public static double calculateTip(double billAmount) {
        if (billAmount < 50) {
            return 0.10;
        } else if (billAmount <= 100) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total bill amount: $");
        double billAmount = scanner.nextDouble();

        System.out.println("Enter the number of people dining: ");
        int NoOfPeople = scanner.nextInt();

        double [] ratios = new double[NoOfPeople];
        System.out.println("Enter the ratio for each of the "+NoOfPeople+" people");
       for (int i=0; i < NoOfPeople; i++) {
           System.out.println("Ratio for person " + (i + 1) + ": ");
           ratios[i] = scanner.nextDouble();
       }
       double totalRatio = 0;
       for (double ratio : ratios) {
           totalRatio += ratio;
       }

       double tipPercentage = calculateTip(billAmount);
       double tipAmount = billAmount * tipPercentage;
       double totalWithTip = billAmount + tipAmount;


        System.out.printf("\nTip percentage: %.0f&&\n", tipPercentage * 100);
        System.out.printf("Total bill with tip: $%.2f\n", totalWithTip);
        System.out.println("\nAmount each person owes");
        for (int i = 0; i < NoOfPeople; i++) {
            double individualBill = (ratios[i] / totalRatio) * totalWithTip;
            System.out.printf("Person %d: $%.2f\n", (i + 1), individualBill);
        }

        scanner.close();
    }
}

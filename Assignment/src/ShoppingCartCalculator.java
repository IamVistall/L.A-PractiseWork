import java.util.Scanner;

public class ShoppingCartCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var total = 0.0;

        System.out.println("Enter the prices for 5 items: ");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Price of item " + i + ": #");
            var price = scanner.nextDouble();
            total += price;
        }

        var discount = 0.0;
        if (total > 200) {
            discount = total * 0.20;
        } else if (total > 100) {
            discount = total * 0.10;
        }

         var finalAmount = total - discount;
        System.out.printf("Total before discount: #%.2f%n", total);
        System.out.printf("Discount applied: #%.2f%n", discount);
        System.out.printf("Final amount to pay: #%.2fd%n", finalAmount);

        scanner.close();
    }
}

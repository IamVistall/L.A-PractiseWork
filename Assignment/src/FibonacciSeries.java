import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            System.out.println("First " + n + " terms of Fibonacci series:");
            printFibonacci(n);
        }

        scanner.close();
    }

    public static void printFibonacci(int n) {
        int first = 0, second = 1;

        if (n >= 1) {
            System.out.print(first);
        }

        if (n >= 2) {
            System.out.println(" " + second);
        }
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.println(" " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
}

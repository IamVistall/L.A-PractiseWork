public class PrimeFactors {
    public static java.util.ArrayList<Integer> findPrimeFactors(int n) {
        java.util.ArrayList<Integer> factors = new java.util.ArrayList<>();
        while (n % 2 == 0) {
            factors.add(2);
            n = n / 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        int number = 100;
        java.util.ArrayList<Integer> result = findPrimeFactors(number);
        System.out.println("Prime factors of " + number + ": " + result);
    }
}

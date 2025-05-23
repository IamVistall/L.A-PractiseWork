public class BinaryToDecimal {
    public static long binaryToDecimal(String binaryStr) {
        long decimal = 0;
        for (int i =  0; i < binaryStr.length(); i++) {
            char digit = binaryStr.charAt(binaryStr.length() - 1 - i);
            if (digit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        // examples
        String binary = "1001";
        long result = binaryToDecimal(binary);
        System.out.println("Binary " + binary + " = Decimal " + result);
    }
}

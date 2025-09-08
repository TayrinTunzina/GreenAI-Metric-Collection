import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {
    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        extraLongFactorials(n);
        scanner.close();
    }
}

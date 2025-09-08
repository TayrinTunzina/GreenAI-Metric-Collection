import java.util.*;
import java.math.BigInteger;

public class BigSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = scanner.nextLine();
        }
        Arrays.sort(unsorted, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        for (String num : unsorted) {
            System.out.println(num);
        }
    }
}
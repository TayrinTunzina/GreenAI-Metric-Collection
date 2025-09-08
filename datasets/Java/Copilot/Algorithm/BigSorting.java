import java.util.*;

public class BigSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] unsorted = new String[n];
        for (int i = 0; i < n; i++) {
            unsorted[i] = scanner.next();
        }

        Arrays.sort(unsorted, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(), b.length());
        });

        for (String num : unsorted) {
            System.out.println(num);
        }
    }
}

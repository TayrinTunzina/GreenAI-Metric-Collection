import java.util.*;

public class BigSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading n

        List<String> unsorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            unsorted.add(scanner.nextLine().trim());
        }

        Collections.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return Integer.compare(a.length(), b.length());
                } else {
                    return a.compareTo(b);
                }
            }
        });

        System.out.println("Sorted array:");
        for (String num : unsorted) {
            System.out.println(num);
        }
    }
}

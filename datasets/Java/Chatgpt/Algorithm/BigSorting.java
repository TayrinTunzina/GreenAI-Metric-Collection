import java.util.*;

public class BigSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            unsorted[i] = sc.nextLine();
        }

        Arrays.sort(unsorted, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return a.length() - b.length();
                return a.compareTo(b); // lexicographic compare
            }
        });

        System.out.println("Sorted output:");
        for (String s : unsorted) {
            System.out.println(s);
        }
    }
}
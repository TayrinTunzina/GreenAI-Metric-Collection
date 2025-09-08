import java.util.Scanner;

public class ArrayManipulation {
    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];

        for (int[] query : queries) {
            int a = query[0], b = query[1], k = query[2];
            arr[a - 1] += k;
            if (b < n) arr[b] -= k;
        }

        long max_value = 0, x = 0;
        for (int i = 0; i < n; ++i) {
            x += arr[i];
            if (x > max_value) max_value = x;
        }

        return max_value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array and the number of operations: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; ++i) {
            System.out.print("Enter the operation (a b k) for operation " + (i + 1) + ": ");
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("The maximum value in the resultant array is: " + arrayManipulation(n, queries));
    }
}

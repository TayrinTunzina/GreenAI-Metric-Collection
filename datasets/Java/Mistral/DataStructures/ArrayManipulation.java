import java.util.Scanner;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];
            arr[a - 1] += k;
            if (b <= n) {
                arr[b] -= k;
            }
        }

        long max_value = 0;
        long running_sum = 0;

        for (long value : arr) {
            running_sum += value;
            if (running_sum > max_value) {
                max_value = running_sum;
            }
        }

        return max_value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of operations: ");
        int m = scanner.nextInt();
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; ++i) {
            System.out.print("Enter the start index (a), end index (b), and value to add (k): ");
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }
        scanner.close();

        long result = arrayManipulation(n, queries);
        System.out.println("The maximum value in the array is: " + result);
    }
}

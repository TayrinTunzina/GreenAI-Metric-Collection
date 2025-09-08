import java.util.Scanner;

public class MaxSiValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int N = sc.nextInt();
        int[] A = new int[N];

        System.out.print("Enter the elements: ");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int max_si = 0;
        for (int i = 0; i < N - 1; i++) {
            int m1 = Math.min(A[i], A[i+1]);
            int m2 = Math.max(A[i], A[i+1]);
            int si = ((m1 & m2) ^ (m1 | m2)) & (m1 ^ m2);
            max_si = Math.max(max_si, si);
        }

        System.out.println("Maximum Si: " + max_si);
        sc.close();
    }
}

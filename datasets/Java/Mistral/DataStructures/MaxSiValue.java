import java.util.*;

public class MaxSiValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.print("Enter the elements of the array separated by space: ");
        for (int i = 0; i < N; ++i) {
            A[i] = scanner.nextInt();
        }

        int maxSiValue = Integer.MIN_VALUE;

        for (int L = 0; L < N; ++L) {
            for (int R = L + 1; R < N; ++R) {
                int[] subarray = Arrays.copyOfRange(A, L, R + 1);
                Arrays.sort(subarray);
                int M1 = subarray[0];
                int M2 = subarray[1];
                int Si = (((M1 & M2) ^ (M1 | M2)) & (M1 ^ M2));
                if (Si > maxSiValue) {
                    maxSiValue = Si;
                }
            }
        }

        System.out.println("The maximum possible value of Si is: " + maxSiValue);
    }
}

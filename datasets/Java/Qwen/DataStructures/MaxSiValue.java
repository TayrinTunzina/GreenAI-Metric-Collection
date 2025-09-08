import java.util.*;

public class MaxSiValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Find Maximum Si ===");
        
        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        if (n < 2) {
            System.out.println("Maximum possible value of Si: 0");
            return;
        }

        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            A[i] = sc.nextLong();
        }

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();

        // Next smaller to the right
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();

        // Previous smaller to the left
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        long maxSi = 0;

        for (int i = 0; i < n; i++) {
            long candidate = -1;

            // Check left
            for (int j = i-1; j > left[i]; j--) {
                if (A[j] > A[i]) {
                    if (candidate == -1 || A[j] < candidate) {
                        candidate = A[j];
                    }
                }
            }

            // Check right
            for (int j = i+1; j < right[i]; j++) {
                if (A[j] > A[i]) {
                    if (candidate == -1 || A[j] < candidate) {
                        candidate = A[j];
                    }
                }
            }

            if (candidate != -1) {
                long si = A[i] ^ candidate;
                if (si > maxSi) {
                    maxSi = si;
                }
            }
        }

        System.out.println("Maximum possible value of Si: " + maxSi);
    }
}
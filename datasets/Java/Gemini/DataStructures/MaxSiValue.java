import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class MaxSiValue {

    // Calculates max XOR using a monotonic stack
    private static long calculateMaxXor(List<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        long maxVal = 0;
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                // Current 'num' is the next smaller element for stack.peek()
                maxVal = Math.max(maxVal, (long)stack.pop() ^ num);
            }
            stack.push(num);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the number of elements (N): ");
            int n = scanner.nextInt();

            if (n <= 1) {
                System.out.println("N must be greater than 1.");
                return;
            }
            
            List<Integer> arr = new ArrayList<>(n);
            System.out.println("Enter " + n + " space-separated integers for the array A[]: ");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            // Pass 1: Left to right (finds max XOR with next smaller elements)
            long max1 = calculateMaxXor(arr);

            // Pass 2: Right to left (finds max XOR with previous smaller elements)
            Collections.reverse(arr);
            long max2 = calculateMaxXor(arr);

            System.out.println("\nMaximum possible value of Si: " + Math.max(max1, max2));

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}
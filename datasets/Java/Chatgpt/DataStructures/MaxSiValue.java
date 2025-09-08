import java.util.*;

public class MaxSiValue {
    public static int maxSi(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxXor = 0;

        for (int num : arr) {
            while (!stack.isEmpty() && stack.peek() < num) {
                maxXor = Math.max(maxXor, stack.pop() ^ num);
            }
            if (!stack.isEmpty()) {
                maxXor = Math.max(maxXor, stack.peek() ^ num);
            }
            stack.push(num);
        }

        return maxXor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        int[] A = new int[N];
        System.out.println("Enter array elements:");
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(maxSi(A));
    }
}

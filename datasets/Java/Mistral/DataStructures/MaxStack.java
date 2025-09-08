import java.util.*;

public class MaxStack {
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> output = new ArrayList<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int x = Integer.parseInt(parts[1]);
                stack.push(x);
                if (maxStack.isEmpty() || x >= maxStack.peek()) {
                    maxStack.push(x);
                }
            } else if (type == 2) {
                if (!stack.isEmpty()) {
                    int popped = stack.pop();
                    if (!maxStack.isEmpty() && popped == maxStack.peek()) {
                        maxStack.pop();
                    }
                }
            } else if (type == 3) {
                if (!maxStack.isEmpty()) {
                    output.add(maxStack.peek());
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of operations: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter operation: ");
            operations.add(scanner.nextLine());
        }

        List<Integer> results = getMax(operations);
        for (int result : results) {
            System.out.println(result);
        }
    }
}

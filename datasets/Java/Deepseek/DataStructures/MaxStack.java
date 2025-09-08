import java.util.*;

public class MaxStack {
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (String op : operations) {
            if (op.startsWith("1")) {
                int num = Integer.parseInt(op.split(" ")[1]);
                stack.push(num);
                if (maxStack.isEmpty() || num >= maxStack.peek()) {
                    maxStack.push(num);
                }
            } else if (op.equals("2")) {
                int popped = stack.pop();
                if (popped == maxStack.peek()) {
                    maxStack.pop();
                }
            } else if (op.equals("3")) {
                result.add(maxStack.peek());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(scanner.nextLine());
        }
        List<Integer> output = getMax(operations);
        for (int num : output) {
            System.out.println(num);
        }
    }
}
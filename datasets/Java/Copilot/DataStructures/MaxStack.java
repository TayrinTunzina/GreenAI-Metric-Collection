import java.util.*;

public class MaxStack {
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (String op : operations) {
            if (op.startsWith("1")) {
                int val = Integer.parseInt(op.split(" ")[1]);
                stack.push(val);
                maxStack.push(maxStack.isEmpty() ? val : Math.max(val, maxStack.peek()));
            } else if (op.equals("2")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    maxStack.pop();
                }
            } else if (op.equals("3")) {
                result.add(maxStack.peek());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        sc.nextLine();
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(sc.nextLine());
        }
        List<Integer> result = getMax(operations);
        System.out.println("Results of max queries:");
        for (int val : result)
            System.out.println(val);
    }
}

import java.io.*;
import java.util.*;

public class MaxStack {
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        for (String operation : operations) {
            if (operation.charAt(0) == '1') {
                // Push operation
                String[] parts = operation.split(" ");
                int x = Integer.parseInt(parts[1]);
                stack.push(x);
                if (maxStack.isEmpty() || x >= maxStack.peek()) {
                    maxStack.push(x);
                }
            } else if (operation.charAt(0) == '2') {
                // Pop operation
                if (!stack.isEmpty()) {
                    int popped = stack.pop();
                    if (!maxStack.isEmpty() && popped == maxStack.peek()) {
                        maxStack.pop();
                    }
                }
            } else if (operation.charAt(0) == '3') {
                // Print maximum
                if (!maxStack.isEmpty()) {
                    result.add(maxStack.peek());
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(scanner.nextLine());
        }
        
        List<Integer> result = getMax(operations);
        for (int res : result) {
            System.out.println(res);
        }
        
        scanner.close();
    }
}
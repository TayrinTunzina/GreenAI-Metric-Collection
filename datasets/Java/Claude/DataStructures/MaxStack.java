import java.util.*;

public class MaxStack {
    
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        
        for (String operation : operations) {
            String[] parts = operation.trim().split(" ");
            int opType = Integer.parseInt(parts[0]);
            
            if (opType == 1) {  // Push element
                int x = Integer.parseInt(parts[1]);
                mainStack.push(x);
                
                // Update maxStack
                if (maxStack.isEmpty()) {
                    maxStack.push(x);
                } else {
                    maxStack.push(Math.max(x, maxStack.peek()));
                }
                
            } else if (opType == 2) {  // Pop element
                if (!mainStack.isEmpty()) {
                    mainStack.pop();
                    maxStack.pop();
                }
                
            } else if (opType == 3) {  // Get maximum
                if (!maxStack.isEmpty()) {
                    results.add(maxStack.peek());
                }
            }
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of operations: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        List<String> operations = new ArrayList<>();
        System.out.println("Enter " + n + " operations:");
        System.out.println("Format: '1 x' for push, '2' for pop, '3' for get max");
        
        for (int i = 0; i < n; i++) {
            operations.add(scanner.nextLine());
        }
        
        List<Integer> results = getMax(operations);
        
        System.out.println("\nResults for type 3 operations (get maximum):");
        for (Integer result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}
import java.util.*;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != mapping.get(c)) {
                    return "NO";
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // To consume the newline after the integer input
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i+1) + ": ");
            String s = scanner.nextLine();
            System.out.println(isBalanced(s));
        }
        
        scanner.close();
    }
}
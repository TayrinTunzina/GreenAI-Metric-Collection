import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {  // Opening bracket
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {  // Closing bracket
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline after the integer input
        
        String[] results = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a string of brackets: ");
            String s = scanner.nextLine();
            results[i] = isBalanced(s);
        }
        
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}
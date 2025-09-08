import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        
        for (char ch : s.toCharArray()) {
            if (bracketMap.containsValue(ch)) {
                stack.push(ch);
            } else if (bracketMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != bracketMap.get(ch)) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the string of brackets: ");
            String s = scanner.next();
            System.out.println(isBalanced(s));
        }
    }
}

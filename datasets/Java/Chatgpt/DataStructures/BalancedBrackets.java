import java.util.*;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (bracketMap.containsValue(ch)) { // Opening brackets
                stack.push(ch);
            } else if (bracketMap.containsKey(ch)) { // Closing brackets
                if (stack.isEmpty() || stack.pop() != bracketMap.get(ch)) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}
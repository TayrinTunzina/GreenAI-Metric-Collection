import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> matchingBracket = new HashMap<>();
        matchingBracket.put(')', '(');
        matchingBracket.put(']', '[');
        matchingBracket.put('}', '{');

        for (char c : s.toCharArray()) {
            if (matchingBracket.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != matchingBracket.get(c)) {
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
        scanner.nextLine(); // Consume newline
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

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AlternateChars {
    public static int alternate(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        int maxLength = 0;

        for (char char1 : chars) {
            for (char char2 : chars) {
                if (char1 == char2) continue;

                StringBuilder filtered = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == char1 || c == char2) {
                        filtered.append(c);
                    }
                }

                boolean valid = true;
                for (int i = 0; i < filtered.length() - 1; i++) {
                    if (filtered.charAt(i) == filtered.charAt(i + 1)) {
                        valid = false;
                        break;
                    }
                }

                if (valid && filtered.length() > maxLength) {
                    maxLength = filtered.length();
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the string: ");
        int length = scanner.nextInt();
        System.out.print("Enter the string: ");
        String s = scanner.next();

        int result = alternate(s);
        System.out.println(result);
    }
}

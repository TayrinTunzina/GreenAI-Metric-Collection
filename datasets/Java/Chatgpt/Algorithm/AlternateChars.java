import java.util.*;

public class AlternateChars {
    static boolean isValid(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                return false;
        }
        return true;
    }

    static int alternate(String s) {
        Set<Character> unique = new HashSet<>();
        for (char c : s.toCharArray()) {
            unique.add(c);
        }

        List<Character> chars = new ArrayList<>(unique);
        int maxLength = 0;

        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                char ch1 = chars.get(i);
                char ch2 = chars.get(j);
                StringBuilder filtered = new StringBuilder();

                for (char c : s.toCharArray()) {
                    if (c == ch1 || c == ch2)
                        filtered.append(c);
                }

                if (isValid(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string length: ");
        int n = scanner.nextInt();
        System.out.print("Enter the string: ");
        String s = scanner.next();

        System.out.println("Longest alternating string length: " + alternate(s));
    }
}

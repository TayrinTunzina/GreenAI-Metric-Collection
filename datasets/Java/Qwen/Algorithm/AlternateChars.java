import java.util.*;

public class AlternateChars {
    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        List<Character> chars = new ArrayList<>(uniqueChars);
        int maxLength = 0;

        // Try all pairs of distinct characters
        for (int i = 0; i < chars.size(); i++) {
            for (int j = i + 1; j < chars.size(); j++) {
                char a = chars.get(i);
                char b = chars.get(j);
                StringBuilder filtered = new StringBuilder();

                for (char c : s.toCharArray()) {
                    if (c == a || c == b) {
                        filtered.append(c);
                    }
                }

                String str = filtered.toString();
                boolean valid = true;

                for (int k = 0; k < str.length() - 1; k++) {
                    if (str.charAt(k) == str.charAt(k + 1)) {
                        valid = false;
                        break;
                    }
                }

                if (valid && str.length() >= 2) {
                    maxLength = Math.max(maxLength, str.length());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();

        System.out.println(alternate(s));
        scanner.close();
    }
}
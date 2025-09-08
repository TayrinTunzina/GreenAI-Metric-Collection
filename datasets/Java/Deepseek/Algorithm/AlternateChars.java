import java.util.HashSet;
import java.util.Set;

public class AlternateChars {
    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        int maxLen = 0;
        
        for (char first : uniqueChars) {
            for (char second : uniqueChars) {
                if (first == second) {
                    continue;
                }
                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == first || c == second) {
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
                if (valid && filtered.length() > maxLen) {
                    maxLen = filtered.length();
                }
            }
        }
        
        return maxLen >= 2 ? maxLen : 0;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        
        System.out.println(alternate(s));
    }
}
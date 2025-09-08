import java.util.*;

public class AlternateChars {
    public static int alternate(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);

        List<Character> unique = new ArrayList<>(set);
        int maxLen = 0;

        for (int i = 0; i < unique.size(); i++) {
            for (int j = i + 1; j < unique.size(); j++) {
                StringBuilder sb = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == unique.get(i) || c == unique.get(j))
                        sb.append(c);
                }
                if (isValid(sb.toString()))
                    maxLen = Math.max(maxLen, sb.length());
            }
        }
        return maxLen;
    }

    public static boolean isValid(String str) {
        for (int i = 0; i < str.length() - 1; i++)
            if (str.charAt(i) == str.charAt(i + 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of string: ");
        int n = sc.nextInt();
        System.out.print("Enter the string: ");
        String s = sc.next();
        System.out.println("Longest length: " + alternate(s));
    }
}

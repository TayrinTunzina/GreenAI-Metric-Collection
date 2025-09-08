import java.util.*;

public class AlternateChars {
    
    public static boolean isAlternating(String s, char char1, char char2) {
        // Filter string to contain only char1 and char2
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == char1 || c == char2) {
                filtered.append(c);
            }
        }
        
        if (filtered.length() < 2) {
            return true;
        }
        
        // Check if it alternates
        for (int i = 1; i < filtered.length(); i++) {
            if (filtered.charAt(i) == filtered.charAt(i-1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static int alternate(String s) {
        // Get all unique characters
        Set<Character> uniqueSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueSet.add(c);
        }
        List<Character> uniqueChars = new ArrayList<>(uniqueSet);
        
        int maxLength = 0;
        
        // Try all pairs of characters
        for (int i = 0; i < uniqueChars.size(); i++) {
            for (int j = i + 1; j < uniqueChars.size(); j++) {
                char char1 = uniqueChars.get(i);
                char char2 = uniqueChars.get(j);
                
                // Create string with only these two characters
                StringBuilder filteredString = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == char1 || c == char2) {
                        filteredString.append(c);
                    }
                }
                
                // Check if this filtered string alternates
                if (isAlternating(filteredString.toString(), char1, char2)) {
                    maxLength = Math.max(maxLength, filteredString.length());
                }
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Java Solution ===");
        
        // Take manual input
        System.out.print("Enter the length of string: ");
        int n = scanner.nextInt();
        System.out.print("Enter the string: ");
        String s = scanner.next();
        
        int result = alternate(s);
        System.out.println("Length of longest alternating string: " + result);
        
        scanner.close();
    }
}
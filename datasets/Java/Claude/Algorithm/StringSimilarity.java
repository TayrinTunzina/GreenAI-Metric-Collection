import java.util.Scanner;

public class StringSimilarity {
    public static long similarity(String s) {
        int n = s.length();
        long total = n;  // Similarity with itself is length of string
        
        // Compare with each suffix
        for(int i = 1; i < n; i++) {
            // Count matching prefix characters
            int j = 0;
            while(j + i < n && s.charAt(j) == s.charAt(j + i)) {
                j++;
            }
            total += j;
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        
        while(t-- > 0) {
            String s = scanner.nextLine();
            System.out.println(similarity(s));
        }
        
        scanner.close();
    }
}
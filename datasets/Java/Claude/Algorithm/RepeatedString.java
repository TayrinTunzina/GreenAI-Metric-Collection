import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

import java.util.Scanner;

public class RepeatedString {
    public static long repeatedString(String s, long n) {
        if (s == null || s.isEmpty()) return 0;
        
        // Count 'a' in original string
        long countInString = s.chars().filter(ch -> ch == 'a').count();
        
        // Calculate complete strings
        long completeStrings = n / s.length();
        
        // Calculate remaining characters
        long remainingChars = n % s.length();
        
        // Count 'a' in remaining substring
        long countInRemaining = s.substring(0, (int)remainingChars)
                               .chars()
                               .filter(ch -> ch == 'a')
                               .count();
        
        return (countInString * completeStrings) + countInRemaining;
    }
    
    private static boolean isLowerCase(String s) {
        return s.chars().allMatch(Character::isLowerCase);
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get input
            System.out.print("Enter the string: ");
            String s = scanner.nextLine().trim();
            
            System.out.print("Enter n: ");
            long n = scanner.nextLong();
            
            // Input validation
            if (s.length() < 1 || s.length() > 100) {
                throw new IllegalArgumentException("String length must be between 1 and 100");
            }
            if (n < 1 || n > Math.pow(10, 12)) {
                throw new IllegalArgumentException("n must be between 1 and 10^12");
            }
            if (!isLowerCase(s)) {
                throw new IllegalArgumentException("String must contain only lowercase letters");
            }
            
            // Calculate and print result
            long result = repeatedString(s, n);
            System.out.println(result);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
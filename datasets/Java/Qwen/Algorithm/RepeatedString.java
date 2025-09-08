import java.util.Scanner;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        // Count the number of 'a's in the original string
        long count_a_in_s = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count_a_in_s++;
            }
        }
        
        // Find how many full repetitions of `s` fit into `n`
        long full_repetitions = n / s.length();
        
        // Find how many extra characters are left after the full repetitions
        long remainder_length = n % s.length();
        
        // Count the number of 'a's in the remaining substring
        long count_a_in_remainder = 0;
        for (int i = 0; i < remainder_length; i++) {
            if (s.charAt(i) == 'a') {
                count_a_in_remainder++;
            }
        }
        
        // Total number of 'a's is the sum of 'a's in full repetitions and remainder
        long total_count_a = count_a_in_s * full_repetitions + count_a_in_remainder;
        
        return total_count_a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.print("Enter the string (s): ");
        String s = scanner.nextLine();
        
        System.out.print("Enter the number of characters to consider (n): ");
        long n = scanner.nextLong();
        
        // Compute and print the result
        long result = repeatedString(s, n);
        System.out.println("The number of 'a's in the first " + n + " characters: " + result);
        
        scanner.close();
    }
}
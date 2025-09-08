import java.util.Scanner;

public class RepeatedString {
    public static long repeatedString(String s, long n) {
        // Step 1: Compute the number of times 'a' appears in the original string `s`.
        long a_count_in_s = s.chars().filter(ch -> ch == 'a').count();
        
        // Step 2: Determine how many full repetitions of `s` fit within `n` characters.
        long full_repeats = n / s.length();
        
        // Step 3: Calculate the remaining substring (if `n` is not a multiple of `len(s)`).
        long remaining_chars = n % s.length();
        
        // Step 4: Count the occurrences of 'a' in the remaining substring.
        long a_count_in_remaining = s.substring(0, (int) remaining_chars).chars().filter(ch -> ch == 'a').count();
        
        // Step 5: Compute the total count of 'a'.
        long total_a_count = full_repeats * a_count_in_s + a_count_in_remaining;
        
        return total_a_count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the number of characters to consider: ");
        long n = scanner.nextLong();
        System.out.println(repeatedString(s, n));
        scanner.close();
    }
}

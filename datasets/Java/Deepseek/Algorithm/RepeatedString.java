import java.util.Scanner;

public class RepeatedString {

    public static long repeatedString(String s, long n) {
        // Count the number of 'a's in the string s
        long count_a = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') count_a++;
        }

        // Calculate the number of full repetitions of s in n characters
        long full_repeats = n / s.length();

        // Calculate the number of 'a's in the full repetitions
        long total_a = full_repeats * count_a;

        // Calculate the remaining characters
        long remainder = n % s.length();

        // Add the number of 'a's in the remaining characters
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') total_a++;
        }

        return total_a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the value of n: ");
        long n = scanner.nextLong();

        System.out.println("Number of 'a's in the first " + n + " characters: " + repeatedString(s, n));

        scanner.close();
    }
}
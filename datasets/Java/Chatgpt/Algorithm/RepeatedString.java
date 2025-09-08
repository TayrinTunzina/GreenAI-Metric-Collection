import java.util.Scanner;

public class RepeatedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        String s = scanner.nextLine();
        long n = scanner.nextLong();

        // Call the function and print the result
        System.out.println(repeatedString(s, n));

        scanner.close();
    }

    public static long repeatedString(String s, long n) {
        // Calculate the number of 'a' in the given string 's'
        long countAInS = s.chars().filter(ch -> ch == 'a').count();

        // Calculate how many times the string 's' repeats fully in the first 'n' characters
        long fullRepetitions = n / s.length();

        // Calculate the remaining characters after full repetitions
        long remainder = n % s.length();

        // Calculate the total number of 'a' in the repeated portion
        long totalA = fullRepetitions * countAInS;

        // Add the number of 'a' in the remaining substring
        totalA += s.substring(0, (int)remainder).chars().filter(ch -> ch == 'a').count();

        return totalA;
    }
}

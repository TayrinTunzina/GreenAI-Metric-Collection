import java.util.Scanner;

public class RepeatedString {

    public static int repeatedString(String s, int n) {
        int count_a_in_s = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                count_a_in_s++;
            }
        }
        int full_repeats = n / s.length();
        int remaining = n % s.length();
        int count_a_in_remaining = 0;
        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') {
                count_a_in_remaining++;
            }
        }
        int total_count = full_repeats * count_a_in_s + count_a_in_remaining;
        return total_count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string s: ");
        String s = scanner.nextLine();
        System.out.print("Enter the integer n: ");
        int n = scanner.nextInt();

        int result = repeatedString(s, n);
        System.out.println("The number of 'a's in the first " + n + " letters of the infinite string is: " + result);
    }
}

import java.util.Scanner;

public class RepeatedString {
    public static int repeatedString(String s, long n) {
        int aCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            }
        }

        long fullRepeats = n / s.length();
        long remaining = n % s.length();

        int totalACount = aCount * (int) fullRepeats;
        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') {
                totalACount++;
            }
        }

        return totalACount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        long n = scanner.nextLong();

        int result = repeatedString(s, n);
        System.out.println(result);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class PrefixCheck {
    public static void noPrefix(String[] words) {
        Arrays.sort(words);
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i + 1].startsWith(words[i])) {
                System.out.println("BAD SET");
                System.out.println(words[i + 1]);
                return;
            }
        }
        System.out.println("GOOD SET");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] words = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        scanner.close();

        noPrefix(words);
    }
}

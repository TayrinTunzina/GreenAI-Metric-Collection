import java.util.Scanner;

public class StringSimilarity {

    public static int[] zFunction(String s) {
        int n = s.length();
        int[] Z = new int[n];
        Z[0] = n;
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                Z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (Z[k] < r - i + 1) {
                    Z[i] = Z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r) == s.charAt(r - l)) {
                        r++;
                    }
                    Z[i] = r - l;
                    r--;
                }
            }
        }

        return Z;
    }

    public static int sumOfSimilarities(String s) {
        int[] Z = zFunction(s);
        int sum = 0;
        for (int value : Z) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < t; i++) {
            String s = sc.nextLine().trim();
            System.out.println(sumOfSimilarities(s));
        }

        sc.close();
    }
}

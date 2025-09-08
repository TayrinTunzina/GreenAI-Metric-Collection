import java.util.Scanner;

public class StringSimilarity {
    public static int[] calculateZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r) == s.charAt(r - l)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r) == s.charAt(r - l)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        z[0] = n;
        return z;
    }

    public static int similaritySum(String s) {
        int[] z = calculateZ(s);
        int sum = 0;
        for (int val : z) {
            sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(similaritySum(s));
        }
        scanner.close();
    }
}

import java.util.Scanner;

public class ForestGame {
    static int computeGrundy(long m, int k) {
        if (m == 1) return 1;
        int depth = 0;
        while (m > 1) {
            m = Math.max(1, m / k);
            depth++;
        }
        return depth % 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        while (g-- > 0) {
            int n = sc.nextInt();
            int xorSum = 0;
            for (int i = 0; i < n; i++) {
                long m = sc.nextLong();
                int k = sc.nextInt();
                xorSum ^= computeGrundy(m, k);
            }
            System.out.println(xorSum != 0 ? "BOB" : "BEN");
        }
        sc.close();
    }
}

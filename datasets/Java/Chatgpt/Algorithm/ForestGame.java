import java.util.*;

public class ForestGame {
    static int grundy(long m, int k) {
        int g = 0;
        while (m > 1) {
            m = (m + k - 2) / k; // ceil((m-1)/k)
            g ^= 1;
        }
        return g;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int G = sc.nextInt();
        while (G-- > 0) {
            System.out.print("Enter number of trees: ");
            int n = sc.nextInt();
            int xor_sum = 0;
            for (int i = 0; i < n; i++) {
                long m = sc.nextLong();
                int k = sc.nextInt();
                xor_sum ^= grundy(m, k);
            }
            System.out.println(xor_sum != 0 ? "BOB" : "BEN");
        }
        sc.close();
    }
}

import java.util.Scanner;

public class ForestGame {
    public static int grundy(long m) {
        if (m == 2) return 0;
        else if (m % 2 == 1) return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        for (int i = 0; i < g; i++) {
            int n = sc.nextInt();
            int xorVal = 0;
            for (int j = 0; j < n; j++) {
                long m = sc.nextLong();
                long k = sc.nextLong();
                xorVal ^= grundy(m);
            }
            System.out.println(xorVal != 0 ? "BOB" : "BEN");
        }
        sc.close();
    }
}
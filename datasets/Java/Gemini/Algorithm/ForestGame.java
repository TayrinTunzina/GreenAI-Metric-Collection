import java.util.Scanner;

public class ForestGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt();
        for (int i = 0; i < g; i++) {
            solve(scanner);
        }
        scanner.close();
    }
    
    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int xor_sum = 0;
        for (int i = 0; i < n; i++) {
            long m = scanner.nextLong();
            int k = scanner.nextInt();
            
            int grundy_num = 0;
            if (m % 2 != 0) { // m is odd
                grundy_num = 1;
            } else { // m is even
                grundy_num = 2;
            }
            
            xor_sum ^= grundy_num;
        }
        
        if (xor_sum != 0) {
            System.out.println("BOB");
        } else {
            System.out.println("BEN");
        }
    }
}
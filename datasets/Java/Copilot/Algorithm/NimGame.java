import java.util.*;

public class NimGame {
    static final int MOD = 1_000_000_007;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int limit = 1 << m;

        boolean[] used = new boolean[limit];
        dfs(new ArrayList<>(), used, n, limit);
        System.out.println(count % MOD);
    }

    static void dfs(List<Integer> path, boolean[] used, int n, int limit) {
        if (path.size() == n) {
            int xor = 0;
            for (int x : path) xor ^= x;
            if (xor != 0) count = (count + 1) % MOD;
            return;
        }

        for (int i = 1; i < limit; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(i);
                dfs(path, used, n, limit);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}

import java.util.*;

public class TreeMetricSpace {
    static ArrayList<Integer>[] tree;
    static int[] dist;

    static void bfs(int start, int n) {
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : tree[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
    }

    static int treeDistance(int u, int v) {
        return Math.abs(dist[u] - dist[v]);
    }

    static int squaredDistance(int[] a, int[] b) {
        return treeDistance(a[0], b[0]) + treeDistance(a[1], b[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        bfs(1, n);
        int far1 = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[far1]) far1 = i;
        }

        bfs(far1, n);

        int[][] points = new int[m][2];
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int maxDist = 0, idx = 0;
        for (int i = 0; i < m; i++) {
            int d = squaredDistance(points[0], points[i]);
            if (d > maxDist) {
                maxDist = d;
                idx = i;
            }
        }

        for (int i = 0; i < m; i++) {
            int d = squaredDistance(points[idx], points[i]);
            if (d > maxDist) maxDist = d;
        }

        System.out.println(maxDist);
    }
}

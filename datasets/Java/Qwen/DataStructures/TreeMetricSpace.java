import java.util.*;

public class TreeMetricSpace {
    public static int[] bfs(List<List<Integer>> graph, int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS from node 1 to find U
        int[] dist1 = bfs(graph, 1, n);
        int U = 1;
        for (int i = 1; i <= n; i++) {
            if (dist1[i] > dist1[U]) {
                U = i;
            }
        }

        // BFS from U to find V
        int[] distU = bfs(graph, U, n);
        int V = U;
        for (int i = 1; i <= n; i++) {
            if (distU[i] > distU[V]) {
                V = i;
            }
        }

        // BFS from V
        int[] distV = bfs(graph, V, n);

        // Read m points and compute 4 values
        List<Long> v1Vals = new ArrayList<>();
        List<Long> v2Vals = new ArrayList<>();
        List<Long> v3Vals = new ArrayList<>();
        List<Long> v4Vals = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            long v1 = (long) distU[x] + distU[y];
            long v2 = (long) distU[x] + distV[y];
            long v3 = (long) distV[x] + distU[y];
            long v4 = (long) distV[x] + distV[y];

            v1Vals.add(v1);
            v2Vals.add(v2);
            v3Vals.add(v3);
            v4Vals.add(v4);
        }

        // Compute range = max - min
        long r1 = Collections.max(v1Vals) - Collections.min(v1Vals);
        long r2 = Collections.max(v2Vals) - Collections.min(v2Vals);
        long r3 = Collections.max(v3Vals) - Collections.min(v3Vals);
        long r4 = Collections.max(v4Vals) - Collections.min(v4Vals);

        long answer = Math.max(Math.max(r1, r2), Math.max(r3, r4));
        System.out.println(answer);

        sc.close();
    }
}
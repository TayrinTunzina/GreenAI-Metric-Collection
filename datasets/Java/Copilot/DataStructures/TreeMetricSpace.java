import java.util.*;

public class TreeMetricSpace {
    static List<List<Integer>> graph;
    static int[] bfs(int start, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : graph.get(node)) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[][] points = new int[m][2];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            used.add(points[i][0]);
            used.add(points[i][1]);
        }

        Map<Integer, int[]> distMap = new HashMap<>();
        for (int v : used) {
            distMap.put(v, bfs(v, n));
        }

        int maxDist = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                int d = distMap.get(points[i][0])[points[j][0]] +
                        distMap.get(points[i][1])[points[j][1]];
                maxDist = Math.max(maxDist, d);
            }
        }

        System.out.println(maxDist);
    }
}

import java.io.*;
import java.util.*;

public class TreeMetricSpace {

    static final int MAXN = 75005;
    static final int LOGN = 17;

    static List<Integer>[] adj = new ArrayList[MAXN];
    static int n, m;
    static int[][] points;
    static int[] depth = new int[MAXN];
    static int[][] parent = new int[MAXN][LOGN];
    static int[] distA = new int[MAXN];
    static int[] distB = new int[MAXN];

    private static void bfs(int startNode, int[] dist) {
        Arrays.fill(dist, -1);
        dist[startNode] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }

    private static int getFarthestNode(int[] dist) {
        int farthestNode = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[farthestNode]) {
                farthestNode = i;
            }
        }
        return farthestNode;
    }

    private static void dfsLca(int u, int p, int d) {
        depth[u] = d;
        parent[u][0] = p;
        for (int i = 1; i < LOGN; i++) {
            parent[u][i] = parent[parent[u][i - 1]][i - 1];
        }
        for (int v : adj[u]) {
            if (v != p) {
                dfsLca(v, u, d + 1);
            }
        }
    }

    private static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = LOGN - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOGN - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }

    private static int getDist(int u, int v) {
        int ancestor = lca(u, v);
        return depth[u] + depth[v] - 2 * depth[ancestor];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        points = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        // Step 1: Find diameter
        int[] tempDist = new int[MAXN];
        bfs(1, tempDist);
        int a = getFarthestNode(tempDist);
        bfs(a, distA);
        int b = getFarthestNode(distA);
        bfs(b, distB);

        // Step 2: Find candidates
        Set<Integer> candidateIndices = new HashSet<>();
        long[] minVals = new long[4];
        long[] maxVals = new long[4];
        int[] minIndices = new int[4];
        int[] maxIndices = new int[4];
        Arrays.fill(minVals, Long.MAX_VALUE);
        Arrays.fill(maxVals, Long.MIN_VALUE);
        Arrays.fill(minIndices, -1);
        Arrays.fill(maxIndices, -1);

        for (int i = 0; i < m; i++) {
            int x = points[i][0];
            int y = points[i][1];
            long[] vals = {
                (long)distA[x] + distB[y], (long)distA[x] - distB[y],
                (long)distB[x] + distA[y], (long)distB[x] - distA[y]
            };
            for(int j=0; j<4; ++j) {
                if (vals[j] < minVals[j]) {
                    minVals[j] = vals[j];
                    minIndices[j] = i;
                }
                if (vals[j] > maxVals[j]) {
                    maxVals[j] = vals[j];
                    maxIndices[j] = i;
                }
            }
        }
        for(int idx : minIndices) if(idx != -1) candidateIndices.add(idx);
        for(int idx : maxIndices) if(idx != -1) candidateIndices.add(idx);
        
        // Step 3: Calculate max distance
        dfsLca(1, 0, 0);

        long maxDist = 0;
        for (int i : candidateIndices) {
            int p1_x = points[i][0];
            int p1_y = points[i][1];
            for (int j = 0; j < m; j++) {
                int p2_x = points[j][0];
                int p2_y = points[j][1];
                long currentDist = (long)getDist(p1_x, p2_x) + getDist(p1_y, p2_y);
                if (currentDist > maxDist) {
                    maxDist = currentDist;
                }
            }
        }

        System.out.println(maxDist);
    }
}
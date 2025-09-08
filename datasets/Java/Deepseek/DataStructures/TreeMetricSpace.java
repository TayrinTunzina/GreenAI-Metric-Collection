import java.io.*;
import java.util.*;

public class TreeMetricSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[][] distance = new int[n+1][n+1];
        for (int u = 1; u <= n; u++) {
            int[] visited = new int[n+1];
            Arrays.fill(visited, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(u);
            visited[u] = 0;
            while (!q.isEmpty()) {
                int current = q.poll();
                for (int neighbor : adj.get(current)) {
                    if (visited[neighbor] == -1) {
                        visited[neighbor] = visited[current] + 1;
                        q.add(neighbor);
                    }
                }
            }
            for (int v = 1; v <= n; v++) {
                distance[u][v] = visited[v];
            }
        }

        List<Pair> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] point = br.readLine().split(" ");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);
            points.add(new Pair(x, y));
        }

        int maxDist = 0;
        for (int i = 0; i < m; i++) {
            Pair p1 = points.get(i);
            for (int j = i+1; j < m; j++) {
                Pair p2 = points.get(j);
                int dist = distance[p1.x][p2.x] + distance[p1.y][p2.y];
                if (dist > maxDist) {
                    maxDist = dist;
                }
            }
        }
        System.out.println(maxDist);
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
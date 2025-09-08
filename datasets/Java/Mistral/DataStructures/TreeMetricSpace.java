import java.util.*;

public class TreeMetricSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of points (m): ");
        int m = scanner.nextInt();

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u and v for each edge):");
        for (int i = 0; i < n - 1; i++) {
            System.out.print("Enter edge " + (i + 1) + " (u v): ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[][] distance = computeDistances(n, tree);

        int[][] points = new int[m][2];
        System.out.println("Enter the points (x and y for each point):");
        for (int i = 0; i < m; i++) {
            System.out.print("Enter point " + (i + 1) + " (x y): ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        int maxDistance = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int currentDistance = distance[points[i][0]][points[j][0]] +
                                     distance[points[i][1]][points[j][1]];
                if (currentDistance > maxDistance) {
                    maxDistance = currentDistance;
                }
            }
        }

        System.out.println("The maximum distance is: " + maxDistance);
    }

    private static int[][] computeDistances(int n, List<List<Integer>> tree) {
        int[][] distance = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : tree.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        distance[i][v] = distance[i][u] + 1;
                        queue.add(v);
                    }
                }
            }
        }

        return distance;
    }
}

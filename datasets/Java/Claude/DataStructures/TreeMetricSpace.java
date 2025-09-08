import java.util.*;

public class TreeMetricSpace {
    
    public static int[] bfsDistances(List<List<Integer>> graph, int start, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int neighbor : graph.get(curr)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[curr] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        return distances;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Build adjacency list for the tree
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Precompute all pairwise distances in the tree
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int[] distances = bfsDistances(graph, i, n);
            for (int j = 1; j <= n; j++) {
                dist[i][j] = distances[j];
            }
        }
        
        // Read the points in the squared metric space
        int[][] points = new int[m][2];
        for (int i = 0; i < m; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        
        // Find maximum distance between any two points
        int maxDistance = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                
                // Distance in squared metric space: ρ(x1,x2) + ρ(y1,y2)
                int distance = dist[x1][x2] + dist[y1][y2];
                maxDistance = Math.max(maxDistance, distance);
            }
        }
        
        System.out.println(maxDistance);
        scanner.close();
    }
}
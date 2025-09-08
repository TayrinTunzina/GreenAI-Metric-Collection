import java.util.*;

public class ReverseFactorization {
    
    static class State {
        long value;
        List<Long> path;
        
        State(long value, List<Long> path) {
            this.value = value;
            this.path = new ArrayList<>(path);
        }
    }
    
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        
        // Manual input - user enters values during runtime
        System.out.print("Enter N and K (space separated): ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        System.out.print("Enter " + k + " elements of array A (space separated): ");
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
        }
        
        // Sort to ensure lexicographic ordering
        Arrays.sort(a);
        
        // BFS
        Queue<State> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        
        List<Long> initialPath = new ArrayList<>();
        initialPath.add(1L);
        queue.offer(new State(1L, initialPath));
        visited.add(1L);
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            if (current.value == n) {
                for (int i = 0; i < current.path.size(); i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(current.path.get(i));
                }
                System.out.println();
                return;
            }
            
            // Try each multiplier in sorted order
            for (int multiplier : a) {
                long nextVal = current.value * multiplier;
                
                // Pruning
                if (nextVal > n) continue;
                
                if (!visited.contains(nextVal)) {
                    visited.add(nextVal);
                    List<Long> newPath = new ArrayList<>(current.path);
                    newPath.add(nextVal);
                    queue.offer(new State(nextVal, newPath));
                }
            }
        }
        
        System.out.println(-1);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Reverse Factorization Problem ===");
        System.out.println("Find the lexicographically smallest path with minimum states from 1 to N");
        System.out.println("Example: N=12, A=[2,3,4] should give output: 1 3 12");
        System.out.println();
        
        solve();
    }
}
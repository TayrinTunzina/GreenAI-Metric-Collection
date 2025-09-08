import java.util.*;
import java.io.*;

public class ForestGame {
    
    public static int mex(Set<Integer> s) {
        int i = 0;
        while (s.contains(i)) {
            i++;
        }
        return i;
    }
    
    public static int calculateGrundy(long m, int k, Map<Long, Integer> memo) {
        if (memo.containsKey(m)) {
            return memo.get(m);
        }
        
        if (m == 1) {
            memo.put(m, 0);
            return 0;
        }
        
        Set<Integer> reachable = new HashSet<>();
        
        // Move 1: Remove entire tree
        reachable.add(0);
        
        // Move 2: Remove leaf nodes
        List<Long> leaves = new ArrayList<>();
        
        // Node 1 is always a leaf if m > 1
        if (m > 1) {
            leaves.add(1L);
        }
        
        // Check other potential leaves
        for (long node = 2; node <= m; node++) {
            int connections = 0;
            
            // Check if this node is a parent
            for (long j = 1; j < m; j++) {
                long parent = Math.max(1L, (j + k - 1) / k);
                if (parent == node) {
                    connections++;
                }
            }
            
            // Check if this node has a parent
            if (node > 1) {
                long edgeNum = node - 1;
                long parent = Math.max(1L, (edgeNum + k - 1) / k);
                if (parent != node) {
                    connections++;
                }
            }
            
            if (connections == 1) {
                leaves.add(node);
            }
        }
        
        // Calculate Grundy numbers for leaf removals
        for (long leaf : leaves) {
            if (leaf == 1 && m > 1) {
                long newM = m - 1;
                reachable.add(calculateGrundy(newM, k, memo));
            } else if (leaf == m) {
                long newM = m - 1;
                reachable.add(calculateGrundy(newM, k, memo));
            }
        }
        
        int grundy = mex(reachable);
        memo.put(m, grundy);
        return grundy;
    }
    
    public static int calculateGrundyOptimized(long m, int k) {
        if (m == 1) {
            return 0;
        } else if (m <= k) {
            return 1;
        } else {
            return (int)((m - 1) % (k + 1));
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int g = scanner.nextInt();
        
        for (int game = 0; game < g; game++) {
            int n = scanner.nextInt();
            int totalGrundy = 0;
            
            for (int i = 0; i < n; i++) {
                long m = scanner.nextLong();
                int k = scanner.nextInt();
                
                // Use optimized calculation
                int treeGrundy = calculateGrundyOptimized(m, k);
                totalGrundy ^= treeGrundy;
            }
            
            if (totalGrundy == 0) {
                System.out.println("BEN");
            } else {
                System.out.println("BOB");
            }
        }
        
        scanner.close();
    }
}
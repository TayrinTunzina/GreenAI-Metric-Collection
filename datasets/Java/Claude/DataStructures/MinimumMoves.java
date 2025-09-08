import java.util.*;

public class MinimumMoves {
    static Map<Integer, Integer> cache = new HashMap<>();
    
    static List<int[]> getFactors(int n) {
        List<int[]> factors = new ArrayList<>();
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                factors.add(new int[]{i, n/i});
            }
        }
        return factors;
    }
    
    static int minMoves(int n) {
        if(cache.containsKey(n))
            return cache.get(n);
            
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
            
        int minSteps = n;
        
        // Try factorization
        List<int[]> factors = getFactors(n);
        for(int[] factor : factors) {
            minSteps = Math.min(minSteps, 1 + minMoves(Math.max(factor[0], factor[1])));
        }
        
        // Try decrementing by 1
        minSteps = Math.min(minSteps, 1 + minMoves(n - 1));
        
        cache.put(n, minSteps);
        return minSteps;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        
        while(Q-- > 0) {
            int N = scanner.nextInt();
            System.out.println(minMoves(N));
        }
        
        scanner.close();
    }
}
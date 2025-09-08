import java.util.*;

public class MaxSiValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        long maxSi = 0;
        
        // Optimized - check all pairs (O(n^2))
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long si = (long)arr[i] ^ arr[j];
                maxSi = Math.max(maxSi, si);
            }
        }
        
        System.out.println("Maximum possible value of Si: " + maxSi);
        sc.close();
    }
}
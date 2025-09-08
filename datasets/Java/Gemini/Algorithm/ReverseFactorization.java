import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ReverseFactorization {

    // Memoization table to store results for subproblems
    static Map<Long, List<Long>> memo = new HashMap<>();
    // The given set of multipliers
    static List<Integer> A = new ArrayList<>();

    // Helper function to compare two paths
    static boolean isBetter(List<Long> newPath, List<Long> currentBestPath) {
        if (currentBestPath == null) {
            return true;
        }
        if (newPath.size() < currentBestPath.size()) {
            return true;
        }
        if (newPath.size() > currentBestPath.size()) {
            return false;
        }
        // Compare lexicographically if lengths are equal
        for (int i = 0; i < newPath.size(); i++) {
            if (newPath.get(i) < currentBestPath.get(i)) return true;
            if (newPath.get(i) > currentBestPath.get(i)) return false;
        }
        return false; // Paths are identical
    }

    // Recursive function to find the optimal path to 'n'
    public static List<Long> solve(long n) {
        // Base case: The path to 1 is just [1]
        if (n == 1) {
            List<Long> path = new ArrayList<>();
            path.add(1L);
            return path;
        }
        // If we have already computed the path for 'n', return it
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<Long> bestPath = null; // null signifies an impossible path

        // Iterate through all possible multipliers
        for (int a : A) {
            if (n % a == 0) {
                // Recursively find the path to the previous number (n / a)
                List<Long> prevPath = solve(n / a);

                // If a path to the previous number exists
                if (prevPath != null) {
                    List<Long> currentPath = new ArrayList<>(prevPath);
                    currentPath.add(n);

                    // Check if the new path is better
                    if (isBetter(currentPath, bestPath)) {
                        bestPath = currentPath;
                    }
                }
            }
        }

        // Store the result in the memoization table and return it
        memo.put(n, bestPath);
        return bestPath;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        System.out.print("Enter N and K: ");
        long N = scanner.nextLong();
        int K = scanner.nextInt();
        System.out.print("Enter the " + K + " elements of set A: ");
        for (int i = 0; i < K; i++) {
            A.add(scanner.nextInt());
        }

        // Sort A in descending order for a better heuristic
        Collections.sort(A, Collections.reverseOrder());

        // Solve the problem for N
        List<Long> result = solve(N);

        // Print the output
        System.out.print("Output: ");
        if (result == null) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
        scanner.close();
    }
}
import java.util.*;

public class ReverseFactorization {
    
    // Helper method to compare two lists lexicographically
    private static int compareLists(List<Long> list1, List<Long> list2) {
        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            int cmp = Long.compare(list1.get(i), list2.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(list1.size(), list2.size());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N and K
        long N = sc.nextLong();
        int K = sc.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            A.add(sc.nextInt());
        }

        // Special case: N is 1
        if (N == 1) {
            System.out.println(1);
            sc.close();
            return;
        }

        // bestPath.get(x) = list of numbers from 1 to x
        Map<Long, List<Long>> bestPath = new HashMap<>();
        List<Long> start = new ArrayList<>();
        start.add(1L);
        bestPath.put(1L, start);

        List<Long> level = new ArrayList<>();
        level.add(1L);

        while (!level.isEmpty()) {
            Map<Long, List<Long>> nextLevelCandidates = new HashMap<>();

            // Sort current level for consistent processing
            Collections.sort(level);

            for (long u : level) {
                if (!bestPath.containsKey(u)) continue;

                for (int a : A) {
                    long v = u * a;
                    if (v > N) continue;

                    List<Long> newPath = new ArrayList<>(bestPath.get(u));
                    newPath.add(v);

                    if (!nextLevelCandidates.containsKey(v)) {
                        nextLevelCandidates.put(v, newPath);
                    } else {
                        List<Long> existing = nextLevelCandidates.get(v);
                        if (compareLists(newPath, existing) < 0) {
                            nextLevelCandidates.put(v, newPath);
                        }
                    }
                }
            }

            List<Long> nextLevel = new ArrayList<>();
            for (Map.Entry<Long, List<Long>> entry : nextLevelCandidates.entrySet()) {
                long v = entry.getKey();
                List<Long> path = entry.getValue();

                if (!bestPath.containsKey(v)) {
                    bestPath.put(v, path);
                    nextLevel.add(v);
                } else {
                    List<Long> oldPath = bestPath.get(v);
                    if (path.size() < oldPath.size()) {
                        bestPath.put(v, path);
                        nextLevel.add(v);
                    } else if (path.size() == oldPath.size() && compareLists(path, oldPath) < 0) {
                        bestPath.put(v, path);
                        nextLevel.add(v);
                    }
                }
            }

            // If we reached N, break early
            if (bestPath.containsKey(N)) {
                break;
            }

            // Remove duplicates
            Set<Long> nextLevelSet = new HashSet<>(nextLevel);
            level = new ArrayList<>(nextLevelSet);
            Collections.sort(level);
        }

        // Output result
        if (bestPath.containsKey(N)) {
            List<Long> path = bestPath.get(N);
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(path.get(i));
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}
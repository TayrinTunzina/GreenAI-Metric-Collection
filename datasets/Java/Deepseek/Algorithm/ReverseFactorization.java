import java.util.*;

public class ReverseFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            A.add(scanner.nextInt());
        }
        Collections.sort(A);
        
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(1);
        queue.add(new Pair(1, initialPath));
        visited.put(1, 1);
        
        List<List<Integer>> foundPaths = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int current = currentPair.value;
            List<Integer> path = currentPair.path;
            
            if (current == N) {
                foundPaths.add(new ArrayList<>(path));
                continue;
            }
            
            for (int num : A) {
                long nextValLong = (long) current * num;
                if (nextValLong > N) continue;
                int nextVal = (int) nextValLong;
                
                if (!visited.containsKey(nextVal) || path.size() + 1 <= visited.get(nextVal)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(nextVal);
                    if (!visited.containsKey(nextVal)) {
                        visited.put(nextVal, newPath.size());
                        queue.add(new Pair(nextVal, newPath));
                    } else if (path.size() + 1 == visited.get(nextVal)) {
                        queue.add(new Pair(nextVal, newPath));
                    }
                }
            }
        }
        
        if (foundPaths.isEmpty()) {
            System.out.println(-1);
            return;
        }
        
        int minLen = Integer.MAX_VALUE;
        for (List<Integer> path : foundPaths) {
            if (path.size() < minLen) {
                minLen = path.size();
            }
        }
        
        List<List<Integer>> candidates = new ArrayList<>();
        for (List<Integer> path : foundPaths) {
            if (path.size() == minLen) {
                candidates.add(path);
            }
        }
        
        candidates.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });
        
        List<Integer> result = candidates.get(0);
        for (int i = 0; i < result.size(); i++) {
            if (i != 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }
    
    static class Pair {
        int value;
        List<Integer> path;
        
        Pair(int value, List<Integer> path) {
            this.value = value;
            this.path = path;
        }
    }
}
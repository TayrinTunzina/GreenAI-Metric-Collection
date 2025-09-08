import java.util.*;

public class CrosswordPuzzle {
    static char[][] grid = new char[10][10];
    static List<String> words = new ArrayList<>();
    static Map<Integer, List<String>> wordLengthMap = new HashMap<>();
    static List<Slot> slots = new ArrayList<>();

    static class Slot {
        char dir;
        int r, c, len;

        Slot(char dir, int r, int c, int len) {
            this.dir = dir;
            this.r = r;
            this.c = c;
            this.len = len;
        }
    }

    static List<Slot> getSlots() {
        List<Slot> slots = new ArrayList<>();

        // Horizontal
        for (int i = 0; i < 10; i++) {
            int j = 0;
            while (j < 10) {
                if (grid[i][j] == '-') {
                    int start = j;
                    while (j < 10 && grid[i][j] == '-') {
                        j++;
                    }
                    int length = j - start;
                    if (length > 1) {
                        slots.add(new Slot('H', i, start, length));
                    }
                } else {
                    j++;
                }
            }
        }

        // Vertical
        for (int j = 0; j < 10; j++) {
            int i = 0;
            while (i < 10) {
                if (grid[i][j] == '-') {
                    int start = i;
                    while (i < 10 && grid[i][j] == '-') {
                        i++;
                    }
                    int length = i - start;
                    if (length > 1) {
                        slots.add(new Slot('V', start, j, length));
                    }
                } else {
                    i++;
                }
            }
        }

        // Sort by length descending
        slots.sort((a, b) -> Integer.compare(b.len, a.len));
        return slots;
    }

    static boolean fits(String word, Slot slot) {
        if (word.length() != slot.len) return false;

        if (slot.dir == 'H') {
            for (int i = 0; i < slot.len; i++) {
                if (grid[slot.r][slot.c + i] != '-' && grid[slot.r][slot.c + i] != word.charAt(i))
                    return false;
            }
        } else {
            for (int i = 0; i < slot.len; i++) {
                if (grid[slot.r + i][slot.c] != '-' && grid[slot.r + i][slot.c] != word.charAt(i))
                    return false;
            }
        }
        return true;
    }

    static List<int[]> place(String word, Slot slot) {
        List<int[]> placed = new ArrayList<>();
        if (slot.dir == 'H') {
            for (int i = 0; i < slot.len; i++) {
                if (grid[slot.r][slot.c + i] == '-') {
                    grid[slot.r][slot.c + i] = word.charAt(i);
                    placed.add(new int[]{slot.r, slot.c + i});
                }
            }
        } else {
            for (int i = 0; i < slot.len; i++) {
                if (grid[slot.r + i][slot.c] == '-') {
                    grid[slot.r + i][slot.c] = word.charAt(i);
                    placed.add(new int[]{slot.r + i, slot.c});
                }
            }
        }
        return placed;
    }

    static void unplace(List<int[]> placed) {
        for (int[] pos : placed) {
            grid[pos[0]][pos[1]] = '-';
        }
    }

    static boolean solve(int idx) {
        if (idx == slots.size()) return true;

        Slot slot = slots.get(idx);
        List<String> candidates = wordLengthMap.get(slot.len);
        if (candidates == null) return false;

        // Copy to avoid concurrent modification
        List<String> temp = new ArrayList<>(candidates);
        for (String word : temp) {
            if (!fits(word, slot)) continue;

            List<int[]> placed = place(word, slot);
            candidates.remove(word);

            if (solve(idx + 1)) return true;

            // Backtrack
            candidates.add(word);
            unplace(placed);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid
        for (int i = 0; i < 10; i++) {
            String row = sc.nextLine();
            grid[i] = row.toCharArray();
        }

        // Read words
        String wordsLine = sc.nextLine();
        String[] wordArr = wordsLine.split(";");
        words.addAll(Arrays.asList(wordArr));

        // Build wordLengthMap
        for (String w : words) {
            wordLengthMap.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }

        // Get slots
        slots = getSlots();

        // Solve
        solve(0);

        // Output
        for (int i = 0; i < 10; i++) {
            System.out.println(new String(grid[i]));
        }

        sc.close();
    }
}
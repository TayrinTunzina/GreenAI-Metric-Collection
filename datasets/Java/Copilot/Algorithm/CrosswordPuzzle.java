import java.util.*;

public class CrosswordPuzzle {
    static boolean canPlace(String word, char[][] grid, int r, int c, boolean hor) {
        if (hor) {
            if (c + word.length() > 10 || (c > 0 && grid[r][c - 1] != '+') || (c + word.length() < 10 && grid[r][c + word.length()] != '+'))
                return false;
            for (int i = 0; i < word.length(); i++) {
                if (grid[r][c + i] != '-' && grid[r][c + i] != word.charAt(i)) return false;
            }
        } else {
            if (r + word.length() > 10 || (r > 0 && grid[r - 1][c] != '+') || (r + word.length() < 10 && grid[r + word.length()][c] != '+'))
                return false;
            for (int i = 0; i < word.length(); i++) {
                if (grid[r + i][c] != '-' && grid[r + i][c] != word.charAt(i)) return false;
            }
        }
        return true;
    }

    static void place(String word, char[][] grid, int r, int c, boolean hor) {
        for (int i = 0; i < word.length(); i++) {
            if (hor) grid[r][c + i] = word.charAt(i);
            else grid[r + i][c] = word.charAt(i);
        }
    }

    static void remove(String word, char[][] grid, int r, int c, boolean hor) {
        for (int i = 0; i < word.length(); i++) {
            if (hor && grid[r][c + i] == word.charAt(i)) grid[r][c + i] = '-';
            else if (!hor && grid[r + i][c] == word.charAt(i)) grid[r + i][c] = '-';
        }
    }

    static boolean solve(char[][] grid, String[] words, int idx) {
        if (idx == words.length) return true;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                for (boolean hor : new boolean[]{true, false}) {
                    if (canPlace(words[idx], grid, r, c, hor)) {
                        place(words[idx], grid, r, c, hor);
                        if (solve(grid, words, idx + 1)) return true;
                        remove(words[idx], grid, r, c, hor);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) grid[i] = sc.next().toCharArray();
        String[] words = sc.next().split(";");
        solve(grid, words, 0);
        for (char[] row : grid) System.out.println(new String(row));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrosswordPuzzle {

    // Checks if a word can be placed horizontally at (r, c)
    private static boolean canPlaceHorizontal(char[][] grid, String word, int r, int c) {
        if (c + word.length() > 10) return false;
        if (c > 0 && grid[r][c - 1] != '+') return false;
        if (c + word.length() < 10 && grid[r][c + word.length()] != '+') return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[r][c + i] != '-' && grid[r][c + i] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Checks if a word can be placed vertically at (r, c)
    private static boolean canPlaceVertical(char[][] grid, String word, int r, int c) {
        if (r + word.length() > 10) return false;
        if (r > 0 && grid[r - 1][c] != '+') return false;
        if (r + word.length() < 10 && grid[r + word.length()][c] != '+') return false;
        for (int i = 0; i < word.length(); i++) {
            if (grid[r + i][c] != '-' && grid[r + i][c] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Main recursive backtracking function
    private static boolean solve(char[][] grid, String[] words, int wordIndex) {
        if (wordIndex == words.length) {
            return true; // Base case: all words placed
        }

        String currentWord = words[wordIndex];
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (grid[r][c] == '-' || grid[r][c] == currentWord.charAt(0)) {
                    // Try placing horizontally
                    if (canPlaceHorizontal(grid, currentWord, r, c)) {
                        char[] originalSlot = new char[currentWord.length()];
                        for (int i = 0; i < currentWord.length(); i++) {
                            originalSlot[i] = grid[r][c + i];
                            grid[r][c + i] = currentWord.charAt(i);
                        }
                        if (solve(grid, words, wordIndex + 1)) {
                            return true;
                        }
                        // Backtrack
                        for (int i = 0; i < currentWord.length(); i++) {
                            grid[r][c + i] = originalSlot[i];
                        }
                    }

                    // Try placing vertically
                    if (canPlaceVertical(grid, currentWord, r, c)) {
                        char[] originalSlot = new char[currentWord.length()];
                        for (int i = 0; i < currentWord.length(); i++) {
                            originalSlot[i] = grid[r + i][c];
                            grid[r + i][c] = currentWord.charAt(i);
                        }
                        if (solve(grid, words, wordIndex + 1)) {
                            return true;
                        }
                        // Backtrack
                        for (int i = 0; i < currentWord.length(); i++) {
                            grid[r + i][c] = originalSlot[i];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String[] crosswordPuzzle(String[] crossword, String wordsStr) {
        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            grid[i] = crossword[i].toCharArray();
        }
        String[] words = wordsStr.split(";");

        solve(grid, words, 0);

        String[] result = new String[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new String(grid[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the 10x10 crossword grid:");
        String[] crossword = new String[10];
        for (int i = 0; i < 10; i++) {
            crossword[i] = reader.readLine();
        }

        System.out.println("\nEnter the semicolon-separated words:");
        String wordsStr = reader.readLine();

        String[] result = crosswordPuzzle(crossword, wordsStr);
        
        System.out.println("\nSolved Crossword:");
        for(String row : result) {
            System.out.println(row);
        }
    }
}
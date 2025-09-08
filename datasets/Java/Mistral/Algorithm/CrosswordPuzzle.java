import java.util.*;

public class CrosswordPuzzle {

    public static boolean canPlaceWord(char[][] grid, String word, int row, int col, boolean horizontal) {
        int length = word.length();
        if (horizontal) {
            if (col + length > 10) return false;
            for (int i = 0; i < length; ++i) {
                if (grid[row][col + i] != '-' && grid[row][col + i] != word.charAt(i)) {
                    return false;
                }
            }
        } else {
            if (row + length > 10) return false;
            for (int i = 0; i < length; ++i) {
                if (grid[row + i][col] != '-' && grid[row + i][col] != word.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void placeWord(char[][] grid, String word, int row, int col, boolean horizontal) {
        int length = word.length();
        if (horizontal) {
            for (int i = 0; i < length; ++i) {
                grid[row][col + i] = word.charAt(i);
            }
        } else {
            for (int i = 0; i < length; ++i) {
                grid[row + i][col] = word.charAt(i);
            }
        }
    }

    public static void unplaceWord(char[][] grid, String word, int row, int col, boolean horizontal) {
        int length = word.length();
        if (horizontal) {
            for (int i = 0; i < length; ++i) {
                grid[row][col + i] = '-';
            }
        } else {
            for (int i = 0; i < length; ++i) {
                grid[row + i][col] = '-';
            }
        }
    }

    public static boolean solveCrossword(char[][] grid, List<String> words, int index) {
        if (index == words.size()) return true;

        String word = words.get(index);
        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 10; ++col) {
                if (grid[row][col] == '-' || grid[row][col] == word.charAt(0)) {
                    if (canPlaceWord(grid, word, row, col, true)) {
                        placeWord(grid, word, row, col, true);
                        if (solveCrossword(grid, words, index + 1)) return true;
                        unplaceWord(grid, word, row, col, true);
                    }
                    if (canPlaceWord(grid, word, row, col, false)) {
                        placeWord(grid, word, row, col, false);
                        if (solveCrossword(grid, words, index + 1)) return true;
                        unplaceWord(grid, word, row, col, false);
                    }
                }
            }
        }
        return false;
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String wordsInput) {
        String[] wordsArray = wordsInput.split(";");
        List<String> words = new ArrayList<>(Arrays.asList(wordsArray));

        words.sort((a, b) -> Integer.compare(b.length(), a.length()));

        char[][] grid = new char[10][10];
        for (int i = 0; i < 10; ++i) {
            grid[i] = crossword.get(i).toCharArray();
        }

        if (solveCrossword(grid, words, 0)) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < 10; ++i) {
                solution.add(new String(grid[i]));
            }
            return solution;
        } else {
            return Collections.singletonList("No solution found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> crossword = new ArrayList<>();

        System.out.println("Enter the crossword grid (10 rows of 10 characters each, use '-' for fillable cells and '+' for blocked cells):");
        for (int i = 0; i < 10; ++i) {
            while (true) {
                System.out.print("Row " + (i + 1) + ": ");
                String row = scanner.nextLine();
                if (row.length() == 10 && row.matches("[+-]+")) {
                    crossword.add(row);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter exactly 10 characters, each being either '+' or '-'.");
                }
            }
        }

        System.out.print("Enter the list of words separated by semicolons: ");
        String words = scanner.nextLine();

        List<String> solution = crosswordPuzzle(crossword, words);
        System.out.println("\nSolution:");
        for (String row : solution) {
            System.out.println(row);
        }
    }
}

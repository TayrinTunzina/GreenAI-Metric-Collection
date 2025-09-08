import java.util.*;

public class CrosswordPuzzle {
    public static boolean canPlaceH(char[][] board, String word, int row, int col) {
        if (col + word.length() > 10 || (col > 0 && board[row][col - 1] != '+') || 
            (col + word.length() < 10 && board[row][col + word.length()] != '+'))
            return false;
        for (int i = 0; i < word.length(); i++)
            if (board[row][col + i] != '-' && board[row][col + i] != word.charAt(i)) return false;
        return true;
    }

    public static boolean canPlaceV(char[][] board, String word, int row, int col) {
        if (row + word.length() > 10 || (row > 0 && board[row - 1][col] != '+') || 
            (row + word.length() < 10 && board[row + word.length()][col] != '+'))
            return false;
        for (int i = 0; i < word.length(); i++)
            if (board[row + i][col] != '-' && board[row + i][col] != word.charAt(i)) return false;
        return true;
    }

    public static List<int[]> placeH(char[][] board, String word, int row, int col) {
        List<int[]> changes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (board[row][col + i] == '-') {
                board[row][col + i] = word.charAt(i);
                changes.add(new int[]{row, col + i});
            }
        }
        return changes;
    }

    public static List<int[]> placeV(char[][] board, String word, int row, int col) {
        List<int[]> changes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (board[row + i][col] == '-') {
                board[row + i][col] = word.charAt(i);
                changes.add(new int[]{row + i, col});
            }
        }
        return changes;
    }

    public static void unplace(char[][] board, List<int[]> changes) {
        for (int[] cell : changes)
            board[cell[0]][cell[1]] = '-';
    }

    public static boolean solve(char[][] board, String[] words, int idx) {
        if (idx == words.length) return true;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (canPlaceH(board, words[idx], r, c)) {
                    List<int[]> changes = placeH(board, words[idx], r, c);
                    if (solve(board, words, idx + 1)) return true;
                    unplace(board, changes);
                }
                if (canPlaceV(board, words[idx], r, c)) {
                    List<int[]> changes = placeV(board, words[idx], r, c);
                    if (solve(board, words, idx + 1)) return true;
                    unplace(board, changes);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) board[i] = sc.nextLine().toCharArray();
        String[] words = sc.nextLine().split(";");

        if (solve(board, words, 0)) {
            for (char[] row : board)
                System.out.println(String.valueOf(row));
        } else {
            System.out.println("No solution found.");
        }
    }
}

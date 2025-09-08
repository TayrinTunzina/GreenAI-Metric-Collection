import java.util.*;

public class CrosswordPuzzle {
    static List<String> grid;
    static List<String> wordList;
    static List<Slot> slots;
    
    static class Slot {
        char direction;
        int row;
        int col;
        int length;
        
        Slot(char direction, int row, int col, int length) {
            this.direction = direction;
            this.row = row;
            this.col = col;
            this.length = length;
        }
    }
    
    static boolean backtrack(int wordIndex) {
        if (wordIndex == wordList.size()) {
            return true;
        }
        
        String currentWord = wordList.get(wordIndex);
        
        for (Slot slot : slots) {
            if (slot.length != currentWord.length()) {
                continue;
            }
            
            boolean canPlace = true;
            char[] originalChars = new char[slot.length];
            
            if (slot.direction == 'h') {
                for (int k = 0; k < slot.length; k++) {
                    char cell = grid.get(slot.row).charAt(slot.col + k);
                    if (cell != '-' && cell != currentWord.charAt(k)) {
                        canPlace = false;
                        break;
                    }
                    originalChars[k] = cell;
                }
            } else { // vertical
                for (int k = 0; k < slot.length; k++) {
                    char cell = grid.get(slot.row + k).charAt(slot.col);
                    if (cell != '-' && cell != currentWord.charAt(k)) {
                        canPlace = false;
                        break;
                    }
                    originalChars[k] = cell;
                }
            }
            
            if (canPlace) {
                // Place the word
                if (slot.direction == 'h') {
                    StringBuilder sb = new StringBuilder(grid.get(slot.row));
                    for (int k = 0; k < slot.length; k++) {
                        sb.setCharAt(slot.col + k, currentWord.charAt(k));
                    }
                    grid.set(slot.row, sb.toString());
                } else {
                    for (int k = 0; k < slot.length; k++) {
                        StringBuilder sb = new StringBuilder(grid.get(slot.row + k));
                        sb.setCharAt(slot.col, currentWord.charAt(k));
                        grid.set(slot.row + k, sb.toString());
                    }
                }
                
                // Recurse
                if (backtrack(wordIndex + 1)) {
                    return true;
                }
                
                // Backtrack
                if (slot.direction == 'h') {
                    StringBuilder sb = new StringBuilder(grid.get(slot.row));
                    for (int k = 0; k < slot.length; k++) {
                        sb.setCharAt(slot.col + k, originalChars[k]);
                    }
                    grid.set(slot.row, sb.toString());
                } else {
                    for (int k = 0; k < slot.length; k++) {
                        StringBuilder sb = new StringBuilder(grid.get(slot.row + k));
                        sb.setCharAt(slot.col, originalChars[k]);
                        grid.set(slot.row + k, sb.toString());
                    }
                }
            }
        }
        
        return false;
    }
    
    static List<String> crosswordPuzzle(List<String> crossword, String words) {
        grid = new ArrayList<>(crossword);
        wordList = new ArrayList<>(Arrays.asList(words.split(";")));
        slots = new ArrayList<>();
        
        // Find horizontal slots
        for (int i = 0; i < 10; i++) {
            int j = 0;
            while (j < 10) {
                if (grid.get(i).charAt(j) == '-') {
                    int start = j;
                    while (j < 10 && grid.get(i).charAt(j) == '-') {
                        j++;
                    }
                    int length = j - start;
                    if (length > 1) {
                        slots.add(new Slot('h', i, start, length));
                    }
                } else {
                    j++;
                }
            }
        }
        
        // Find vertical slots
        for (int j = 0; j < 10; j++) {
            int i = 0;
            while (i < 10) {
                if (grid.get(i).charAt(j) == '-') {
                    int start = i;
                    while (i < 10 && grid.get(i).charAt(j) == '-') {
                        i++;
                    }
                    int length = i - start;
                    if (length > 1) {
                        slots.add(new Slot('v', start, j, length));
                    }
                } else {
                    i++;
                }
            }
        }
        
        // Sort slots by length (descending)
        slots.sort((a, b) -> Integer.compare(b.length, a.length));
        
        // Start backtracking
        backtrack(0);
        
        return grid;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> crossword = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            crossword.add(scanner.nextLine());
        }
        
        String words = scanner.nextLine();
        
        List<String> result = crosswordPuzzle(crossword, words);
        for (String row : result) {
            System.out.println(row);
        }
    }
}
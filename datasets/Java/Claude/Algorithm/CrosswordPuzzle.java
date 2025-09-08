import java.util.*;

class Slot {
    char direction; // 'H' for horizontal, 'V' for vertical
    int row, col, length;
    
    public Slot(char direction, int row, int col, int length) {
        this.direction = direction;
        this.row = row;
        this.col = col;
        this.length = length;
    }
}

public class CrosswordPuzzle {
    private char[][] grid;
    private String[] words;
    private List<Slot> slots;
    
    private List<Slot> findSlots() {
        List<Slot> result = new ArrayList<>();
        
        // Find horizontal slots
        for (int i = 0; i < 10; i++) {
            int j = 0;
            while (j < 10) {
                if (grid[i][j] == '-') {
                    int start = j;
                    int length = 0;
                    while (j < 10 && grid[i][j] == '-') {
                        length++;
                        j++;
                    }
                    if (length > 1) {
                        result.add(new Slot('H', i, start, length));
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
                if (grid[i][j] == '-') {
                    int start = i;
                    int length = 0;
                    while (i < 10 && grid[i][j] == '-') {
                        length++;
                        i++;
                    }
                    if (length > 1) {
                        result.add(new Slot('V', start, j, length));
                    }
                } else {
                    i++;
                }
            }
        }
        
        return result;
    }
    
    private boolean canPlaceWord(String word, Slot slot) {
        if (word.length() != slot.length) {
            return false;
        }
        
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                char cell = grid[slot.row][slot.col + k];
                if (cell != '-' && cell != word.charAt(k)) {
                    return false;
                }
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                char cell = grid[slot.row + k][slot.col];
                if (cell != '-' && cell != word.charAt(k)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private String placeWord(String word, Slot slot) {
        StringBuilder previousState = new StringBuilder();
        
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                previousState.append(grid[slot.row][slot.col + k]);
                grid[slot.row][slot.col + k] = word.charAt(k);
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                previousState.append(grid[slot.row + k][slot.col]);
                grid[slot.row + k][slot.col] = word.charAt(k);
            }
        }
        
        return previousState.toString();
    }
    
    private void removeWord(Slot slot, String previousState) {
        if (slot.direction == 'H') {
            for (int k = 0; k < slot.length; k++) {
                grid[slot.row][slot.col + k] = previousState.charAt(k);
            }
        } else { // Vertical
            for (int k = 0; k < slot.length; k++) {
                grid[slot.row + k][slot.col] = previousState.charAt(k);
            }
        }
    }
    
    private boolean solve(int wordIndex, Set<Integer> usedSlots) {
        if (wordIndex == words.length) {
            return true;
        }
        
        String word = words[wordIndex];
        
        for (int i = 0; i < slots.size(); i++) {
            if (usedSlots.contains(i)) {
                continue;
            }
            
            if (canPlaceWord(word, slots.get(i))) {
                String previousState = placeWord(word, slots.get(i));
                usedSlots.add(i);
                
                if (solve(wordIndex + 1, usedSlots)) {
                    return true;
                }
                
                // Backtrack
                removeWord(slots.get(i), previousState);
                usedSlots.remove(i);
            }
        }
        
        return false;
    }
    
    public String[] crosswordPuzzle(String[] crossword, String wordsStr) {
        // Initialize grid
        grid = new char[10][10];
        for (int i = 0; i < 10; i++) {
            grid[i] = crossword[i].toCharArray();
        }
        
        // Parse words
        words = wordsStr.split(";");
        
        // Find slots
        slots = findSlots();
        
        // Solve
        Set<Integer> usedSlots = new HashSet<>();
        if (solve(0, usedSlots)) {
            String[] result = new String[10];
            for (int i = 0; i < 10; i++) {
                result[i] = new String(grid[i]);
            }
            return result;
        }
        
        return new String[0];
    }
    
    public static void main(String[] args) {
        CrosswordPuzzle solver = new CrosswordPuzzle();
        Scanner scanner = new Scanner(System.in);
        
        // Test case
        String[] testCrossword = {
            "++++++++++",
            "+------+++",
            "+++-++++++",
            "+++-++++++",
            "+++-----++",
            "+++-++-+++",
            "++++++-+++",
            "++++++-+++",
            "++++++-+++",
            "++++++++++"
        };
        String testWords = "POLAND;LHASA;SPAIN;INDIA";
        
        System.out.println("Test case result:");
        String[] result = solver.crosswordPuzzle(testCrossword, testWords);
        for (String row : result) {
            System.out.println(row);
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Manual input mode:");
        
        // Manual input
        String[] crossword = new String[10];
        System.out.println("Enter the 10x10 crossword grid (10 lines):");
        for (int i = 0; i < 10; i++) {
            crossword[i] = scanner.nextLine().trim();
        }
        
        System.out.println("Enter the semicolon-separated words:");
        String words = scanner.nextLine().trim();
        
        CrosswordPuzzle manualSolver = new CrosswordPuzzle();
        String[] manualResult = manualSolver.crosswordPuzzle(crossword, words);
        
        System.out.println("\nSolved crossword:");
        for (String row : manualResult) {
            System.out.println(row);
        }
        
        scanner.close();
    }
}
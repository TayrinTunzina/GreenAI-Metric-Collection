import java.util.Scanner;

public class DiagonalDifference {
    public static int diagonalDifference(int[][] arr, int n) {
        int primary_diagonal = 0;
        int secondary_diagonal = 0;
        
        for(int i = 0; i < n; i++) {
            primary_diagonal += arr[i][i];
            secondary_diagonal += arr[i][n-1-i];
        }
        
        return Math.abs(primary_diagonal - secondary_diagonal);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of square matrix: ");
        int n = scanner.nextInt();
        
        int[][] arr = new int[n][n];
        
        System.out.println("Enter the matrix elements row by row:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        int result = diagonalDifference(arr, n);
        System.out.println("Absolute diagonal difference: " + result);
        
        scanner.close();
    }
}
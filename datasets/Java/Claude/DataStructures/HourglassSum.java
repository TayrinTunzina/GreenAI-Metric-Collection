import java.util.Scanner;

public class HourglassSum {
    public static int maxHourglassSum() {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];
        
        // Input
        System.out.println("Enter the 6x6 matrix elements row by row:");
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // Calculate sum for each hourglass
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int currentSum = 
                    // Top row
                    arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                    // Middle
                    arr[i+1][j+1] +
                    // Bottom row
                    arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        scanner.close();
        return maxSum;
    }
    
    public static void main(String[] args) {
        System.out.println("Maximum hourglass sum: " + maxHourglassSum());
    }
}
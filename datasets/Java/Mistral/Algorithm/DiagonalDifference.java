import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(n - i - 1);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix: ");
        int n = scanner.nextInt();

        List<List<Integer>> arr = new ArrayList<>();
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            arr.add(row);
        }

        int result = diagonalDifference(arr);
        System.out.println("The absolute difference between the sums of the diagonals is: " + result);

        scanner.close();
    }
}

import java.util.*;

public class PetrolPumpTour {
    public static int findStartingPump(int n, int[][] pumps) {
        int totalSurplus = 0, currentSurplus = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            int petrol = pumps[i][0], distance = pumps[i][1];
            int surplus = petrol - distance;
            totalSurplus += surplus;
            currentSurplus += surplus;

            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pumps = new int[n][2];

        for (int i = 0; i < n; i++) {
            pumps[i][0] = sc.nextInt();
            pumps[i][1] = sc.nextInt();
        }

        System.out.println(findStartingPump(n, pumps));
        sc.close();
    }
}

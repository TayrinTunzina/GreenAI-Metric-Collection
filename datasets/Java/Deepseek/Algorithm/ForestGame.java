import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForestGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt();
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < g; i++) {
            int n = scanner.nextInt();
            List<Tree> trees = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int m = scanner.nextInt();
                int k = scanner.nextInt();
                trees.add(new Tree(m, k));
            }
            games.add(new Game(n, trees));
        }
        List<String> results = determineWinner(games);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static List<String> determineWinner(List<Game> games) {
        List<String> results = new ArrayList<>();
        for (Game game : games) {
            int n = game.n;
            List<Tree> trees = game.trees;
            int totalXor = 0;
            for (Tree tree : trees) {
                int m = tree.m;
                int k = tree.k;
                if (m == 1) {
                    totalXor ^= 1;
                } else {
                    if ((m - 1) % (k + 1) == 0) {
                        // grundy number is 0, do nothing
                    } else {
                        totalXor ^= 1;
                    }
                }
            }
            if (totalXor != 0) {
                results.add("BOB");
            } else {
                results.add("BEN");
            }
        }
        return results;
    }

    static class Game {
        int n;
        List<Tree> trees;

        Game(int n, List<Tree> trees) {
            this.n = n;
            this.trees = trees;
        }
    }

    static class Tree {
        int m;
        int k;

        Tree(int m, int k) {
            this.m = m;
            this.k = k;
        }
    }
}
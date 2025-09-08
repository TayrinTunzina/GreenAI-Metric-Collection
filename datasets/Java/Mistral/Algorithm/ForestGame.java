import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForestGame {

    public static int computeGrundy(int m, int k) {
        return m - (m / k);
    }

    public static void determineWinner(List<Game> games) {
        for (Game game : games) {
            int xorSum = 0;
            for (Tree tree : game.trees) {
                int grundy = computeGrundy(tree.m, tree.k);
                xorSum ^= grundy;
            }
            if (xorSum != 0) {
                System.out.println("BOB");
            } else {
                System.out.println("BEN");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of games: ");
        int g = scanner.nextInt();
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < g; ++i) {
            System.out.print("Enter the number of trees in the forest: ");
            int n = scanner.nextInt();
            List<Tree> trees = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                System.out.print("Enter m and k for the tree: ");
                int m = scanner.nextInt();
                int k = scanner.nextInt();
                trees.add(new Tree(m, k));
            }
            games.add(new Game(n, trees));
        }
        determineWinner(games);
    }

    static class Game {
        int n;
        List<Tree> trees;

        public Game(int n, List<Tree> trees) {
            this.n = n;
            this.trees = trees;
        }
    }

    static class Tree {
        int m;
        int k;

        public Tree(int m, int k) {
            this.m = m;
            this.k = k;
        }
    }
}

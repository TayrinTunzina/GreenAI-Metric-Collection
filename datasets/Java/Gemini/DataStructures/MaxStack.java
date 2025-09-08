import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxStack {

    /**
     * Processes a list of stack operations and returns the results of all '3' queries.
     * @param operations A list of strings, where each string is a query.
     * @return A list of integers containing the answers to each type 3 query.
     */
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        List<Integer> results = new ArrayList<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1:
                    int val = Integer.parseInt(parts[1]);
                    mainStack.push(val);
                    if (maxStack.isEmpty() || val >= maxStack.peek()) {
                        maxStack.push(val);
                    }
                    break;
                case 2:
                    if (!mainStack.isEmpty()) {
                        int popped = mainStack.pop();
                        if (popped == maxStack.peek()) {
                            maxStack.pop();
                        }
                    }
                    break;
                case 3:
                    if (!maxStack.isEmpty()) {
                        results.add(maxStack.peek());
                    }
                    break;
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ops.add(bufferedReader.readLine());
        }

        List<Integer> res = getMax(ops);

        for (int val : res) {
            System.out.println(val);
        }
        
        bufferedReader.close();
    }
}
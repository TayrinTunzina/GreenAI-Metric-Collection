import java.util.Scanner;
import java.util.Stack;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(int node_data) {
        this.data = node_data;
        this.next = null;
    }
}

public class ReversePrint {
    public static void reversePrint(SinglyLinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode current = head;
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.print("Enter the number of elements in the list: ");
            int n = scanner.nextInt();
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;
            for (int i = 0; i < n; ++i) {
                System.out.print("Enter the data element: ");
                int data = scanner.nextInt();
                SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
                if (head == null) {
                    head = new_node;
                    tail = new_node;
                } else {
                    tail.next = new_node;
                    tail = new_node;
                }
            }
            reversePrint(head);
        }
        scanner.close();
    }
}

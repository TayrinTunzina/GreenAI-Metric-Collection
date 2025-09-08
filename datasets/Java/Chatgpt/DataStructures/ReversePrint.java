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
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("\nEnter the number of elements in the list: ");
            int n = scanner.nextInt();

            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;

            for (int j = 0; j < n; j++) {
                int data = scanner.nextInt();
                SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;
            }

            System.out.println("\nReversed list:");
            reversePrint(head);
        }

        scanner.close();
    }
}

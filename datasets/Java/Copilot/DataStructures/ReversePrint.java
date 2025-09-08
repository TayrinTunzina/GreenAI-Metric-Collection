import java.util.Scanner;
import java.util.Stack;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    
    SinglyLinkedListNode(int data) {
        this.data = data;
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
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    public static SinglyLinkedListNode createLinkedList(int n, Scanner scanner) {
        SinglyLinkedListNode head = null;
        if (n > 0) {
            head = new SinglyLinkedListNode(scanner.nextInt());
            SinglyLinkedListNode current = head;
            for (int i = 1; i < n; i++) {
                SinglyLinkedListNode new_node = new SinglyLinkedListNode(scanner.nextInt());
                current.next = new_node;
                current = new_node;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            SinglyLinkedListNode head = createLinkedList(n, scanner);
            if (head != null) {
                reversePrint(head);
            }
        }
        scanner.close();
    }
}

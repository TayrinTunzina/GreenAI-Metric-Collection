import java.util.Scanner;

// Definition for singly-linked list node
class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
    SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversePrint {
    // Function to print the reversed linked list
    public static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.print("Enter number of elements in the list: ");
            int n = scanner.nextInt();
            SinglyLinkedListNode head = null;
            if (n > 0) {
                head = new SinglyLinkedListNode(scanner.nextInt());
                SinglyLinkedListNode current = head;
                for (int i = 1; i < n; i++) {
                    current.next = new SinglyLinkedListNode(scanner.nextInt());
                    current = current.next;
                }
            }
            // Call reversePrint
            reversePrint(head);
            System.out.println();
        }
        scanner.close();
    }
}